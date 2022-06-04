package gonzalez.hernandez.runevo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import gonzalez.hernandez.runevo.databinding.ActivityRegistrarseBinding

class RegistrarseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        val imgDevolver = findViewById<ImageButton>(R.id.btnBackCreateA)
        val btnRegistrarse = findViewById<Button>(R.id.btnRegistro)

        imgDevolver.setOnClickListener {
            val lanzar = Intent(this, iniciarSesion::class.java)
            startActivity(lanzar)
        }

        btnRegistrarse.setOnClickListener{
            val intent = Intent(this, iniciarSesion::class.java)
            this.startActivity(intent)
        }

    }
}