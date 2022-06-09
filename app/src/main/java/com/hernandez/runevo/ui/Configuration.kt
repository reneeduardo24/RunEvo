package com.hernandez.runevo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.hernandez.runevo.ui.fragments.SettingsFragment
import com.hernandez.runevo.ui.iniciarSesion

class Configuration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration)

        val imgDevolver = findViewById<ImageButton>(R.id.btnBackCreateA)
        val btnCerrarSesion = findViewById<TextView>(R.id.btn_cerrar_sesion)

        imgDevolver.setOnClickListener{
            val intent = Intent(this, SettingsFragment::class.java)
            this.startActivity(intent)
        }

        btnCerrarSesion.setOnClickListener{
            val intent = Intent(this, iniciarSesion::class.java)
            this.startActivity(intent)
        }
    }
}