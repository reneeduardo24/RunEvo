package com.hernandez.runevo.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hernandez.runevo.R
import com.hernandez.runevo.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class iniciarSesion : AppCompatActivity() {
    companion object {
        var email: String? = null
    }

    private lateinit var auth: FirebaseAuth
    private lateinit var mPreferences: SharedPreferences
    private lateinit var mEditor: SharedPreferences.Editor
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciarSesion.setOnClickListener{
            validaSesion()
        }

        binding.btnRegistrarse.setOnClickListener{
            val intent = Intent(this, RegistrarseActivity::class.java)
            this.startActivity(intent)
        }

        binding.txtOlvidaPass.setOnClickListener{
            val lanzar = Intent(this, RecoveryActivity:: class.java)
            startActivity(lanzar)
        }



    }

    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun validaSesion() {
        val et_correo: EditText = findViewById(R.id.et_user)
        val et_contra: EditText = findViewById(R.id.et_password)

        var correo: String = et_correo.text.toString()
        var contra: String = et_contra.text.toString()

        if(!correo.isNullOrBlank() && !contra.isNullOrBlank()){
            ingresaFirebase(correo,contra)
            email = correo
        }else if(!validarEmail(correo)){
            Toast.makeText(this, "Email no válido", Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(baseContext, "Autenticacion fallida.",
                        Toast.LENGTH_SHORT).show()
                }
            }

    }
}