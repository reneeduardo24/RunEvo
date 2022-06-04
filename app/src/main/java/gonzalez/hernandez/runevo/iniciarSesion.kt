package gonzalez.hernandez.runevo

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import gonzalez.hernandez.runevo.databinding.ActivityIniciarSesionBinding
import com.google.firebase.ktx.Firebase

class iniciarSesion : AppCompatActivity() {
    companion object {
        var email: String? = null
    }

    private lateinit var auth: FirebaseAuth
    private lateinit var mPreferences: SharedPreferences
    private lateinit var mEditor: SharedPreferences.Editor
    private lateinit var binding: ActivityIniciarSesionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        auth = Firebase.auth

        binding = ActivityIniciarSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciarSesion.setOnClickListener{
            validaSesion()
        }

        binding.btnRegistrarse.setOnClickListener{
            val intent = Intent(this, RegistrarseActivity::class.java)
            this.startActivity(intent)
        }



    }

    private fun validaSesion() {
        val et_correo: EditText = findViewById(R.id.et_user)
        val et_contra: EditText = findViewById(R.id.et_password)

        var correo: String = et_correo.text.toString()
        var contra: String = et_contra.text.toString()

        if(!correo.isNullOrBlank() && !contra.isNullOrBlank()){
            ingresaFirebase(correo,contra)
            email = correo
        }else{
            Toast.makeText(this,"Ingresar datos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun ingresaFirebase(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val lanzar = Intent(this, MainActivity:: class.java)
                    startActivity(lanzar)
                } else {
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }

    }
}