package gonzalez.hernandez.runevo.ui.perfil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import gonzalez.hernandez.runevo.Configuracion
import gonzalez.hernandez.runevo.R
import gonzalez.hernandez.runevo.RegistrarseActivity
import gonzalez.hernandez.runevo.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {
    private var _binding: FragmentPerfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val bind = FragmentPerfilBinding.inflate(layoutInflater)
        val perfilViewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)

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