package gonzalez.hernandez.runevo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import gonzalez.hernandez.runevo.databinding.ActivityConfiguracionBinding
import gonzalez.hernandez.runevo.ui.perfil.PerfilFragment

class Configuracion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        val imgDevolver = findViewById<ImageButton>(R.id.btnBackCreateA)
        val btnCerrarSesion = findViewById<TextView>(R.id.btn_cerrar_sesion)

        imgDevolver.setOnClickListener{
            val intent = Intent(this, PerfilFragment::class.java)
            this.startActivity(intent)
        }

        btnCerrarSesion.setOnClickListener{
            val intent = Intent(this, iniciarSesion::class.java)
            this.startActivity(intent)
        }
    }
}