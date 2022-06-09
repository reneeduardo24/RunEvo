package com.hernandez.runevo.ui

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.hernandez.runevo.R
import com.hernandez.runevo.databinding.ActivityRecoveryBinding

class RecoveryActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityRecoveryBinding
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)
        binding = ActivityRecoveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()

        //Init /setup progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Por favor espere.")
        progressDialog.setCanceledOnTouchOutside(false)


        //SetOnClickListener
        binding.btnRecuperar.setOnClickListener{
            validateData()
        }

        val imgDevolver = findViewById<ImageView>(R.id.btnBackRec)

        imgDevolver.setOnClickListener {
            val lanzar = Intent(this, iniciarSesion::class.java)
            startActivity(lanzar)
        }
    }

    private var email = ""
    private fun validateData() {
        //get data
        email = binding.txtUsuario.text.toString().trim()

        //validate data
        if(email.isEmpty()){
            Toast.makeText(this, "Ingresa email...", Toast.LENGTH_SHORT).show()
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            Toast.makeText(this, "Email invalido...", Toast.LENGTH_SHORT).show()
        }else{
            recoverPassword()
        }
    }

    private fun recoverPassword() {
        //show progress
        progressDialog.setMessage("Enviando instrucciones para recuperar.")
        progressDialog.show()

        firebaseAuth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                //sent
                progressDialog.dismiss()
                Toast.makeText(this, "Instrucciones mandadas a " + email, Toast.LENGTH_SHORT).show()
                val lanzar = Intent(this, iniciarSesion::class.java)
                startActivity(lanzar)
            }
            .addOnFailureListener {
                //failed
                progressDialog.dismiss()
                Toast.makeText(this, "Fallo al enviar el correo", Toast.LENGTH_SHORT).show()
            }
    }
}