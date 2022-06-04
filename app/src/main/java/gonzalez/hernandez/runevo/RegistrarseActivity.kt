package gonzalez.hernandez.runevo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class RegistrarseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        val imgDevolver = findViewById<ImageView>(R.id.btnBackCreateA)

        imgDevolver.setOnClickListener {
            val lanzar = Intent(this, iniciarSesion::class.java)
            startActivity(lanzar)
        }

    }
}