package com.hernandez.runevo.ui

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.hernandez.runevo.R
import com.hernandez.runevo.ui.RegistrarseActivity.Companion.user
import com.hernandez.runevo.ui.iniciarSesion.Companion.email

class ConfiguraPerfilActivity : AppCompatActivity() {
    var perfiles = ArrayList<Perfil>()
    private lateinit var auth: FirebaseAuth

    var count = 0

    companion object {
        var perfil: Perfil? = null

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configura_perfil)

        val fs = Firebase.firestore
        auth = Firebase.auth

        val bundle = intent.extras
        var nombrePerfil = ""

        if(bundle != null){
            nombrePerfil = bundle.getString("nombrePerfil").toString()
        }

        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente)
        val btnMenos = findViewById<ImageView>(R.id.btnDecrement)
        val btnMas = findViewById<ImageView>(R.id.btnIncrement)
        val edad = findViewById<TextView>(R.id.txtEdad)
        val et_nombre = findViewById<EditText>(R.id.txtNombre)
        val imgDevolver = findViewById<ImageView>(R.id.btnBackConfP)

        imgDevolver.setOnClickListener {
            val lanzar = Intent(this, RegistrarseActivity::class.java)
            startActivity(lanzar)
        }

        btnMenos.setOnClickListener{
            if(count == 0){

            }else {
                count = count - 1
                var txtEdad = (count).toString()
                edad.setText(txtEdad)
            }
        }

        btnMas.setOnClickListener{
            count = count + 1
            var txtEdad = (count).toString()
            edad.setText(txtEdad)
        }

        btnSiguiente.setOnClickListener{
            perfil = Perfil(et_nombre.text.toString(),count)

            //////////////////////////////////

            var edad = perfil!!.edad
            var nombre = perfil!!.nombre

            var pf = Perfil(nombre,edad)

            if(!perfiles.contains(pf)){
                perfiles.add(pf)
            }


            if(user != null){
                var correo = user!!.email
                var contraseña = user!!.contraseña
                var usuario = user?.usuario
                var gmail = user?.email

                val user = hashMapOf(
                    "usuario" to usuario,
                    "email" to gmail,
                    "contraseña" to contraseña,
                    "perfiles" to perfiles)


                fs.collection("users")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        Log.d(
                            ContentValues.TAG,
                            "DocumentSnapshot added with ID: ${documentReference.id}"
                        )
                    }
                    .addOnFailureListener { e ->
                        Log.w(ContentValues.TAG, "Error adding document", e)
                    }

                registrarFireBase(correo, contraseña)

            } else {
                var correo = email
                fs.collection("users").whereEqualTo("email", email).get()
                    .addOnSuccessListener { documents ->
                        for (document in documents) {
                            fs.collection("users").document(document.id).update("perfiles",
                                FieldValue.arrayUnion(pf))
                        }
                    }
            }

            //////////////////////////////////

            val lanzar = Intent(this, MainActivity:: class.java)
            startActivity(lanzar)
        }
    }

    private fun registrarFireBase(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(ContentValues.TAG, "Se creo correctamente el usuario")
                    val user = auth.currentUser
                    val lanzar = Intent(this, ConfiguraPerfilActivity:: class.java)
                    startActivity(lanzar)
                } else {
                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }

    }
}