package gonzalez.hernandez.runevo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import gonzalez.hernandez.runevo.databinding.ActivityMainBinding
import gonzalez.hernandez.runevo.ui.perfil.PerfilFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val editText = findViewById<TextView>(R.id.txtPerfilName)

        AppBarConfiguration(
            setOf(
                R.id.nav_trofeos, R.id.nav_comunidad, R.id.nav_carrera, R.id.nav_historial, R.id.nav_perfil
            )
        )
        navView.setupWithNavController(navController)

        fun changeEditText(name:String){
            editText.setText(name)
        }
    }
}