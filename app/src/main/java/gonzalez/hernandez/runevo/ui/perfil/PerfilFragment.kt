package gonzalez.hernandez.runevo.ui.perfil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import gonzalez.hernandez.runevo.*
import gonzalez.hernandez.runevo.databinding.FragmentPerfilBinding


class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    val fs = Firebase.firestore
    private val binding get() = _binding!!

    companion object{
        var perfilActivo: Perfil? = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val bind = FragmentPerfilBinding.inflate(layoutInflater)
        val perfilViewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)


        fs.collection("users").whereEqualTo("email", iniciarSesion.email).get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    var perfiles = document.get("perfiles")
                    for (perfil in perfiles as ArrayList<Any>) {
                        perfil as HashMap<String, Any>
                        var nombrepf = perfil.get("nombre")

                        Toast.makeText(activity,"Si entra " + nombrepf,Toast.LENGTH_SHORT).show();
                        binding.txtPerfilName.text = nombrepf.toString()
                    }
                }

                }

        //////////////

        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //aqui es para ir a configuracion

        bind.tvConfig.setOnClickListener {
            val intent = Intent(this@PerfilFragment.requireContext(), Configuracion::class.java)
            startActivity(intent)
        }

        return bind.root
        return root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}