package gonzalez.hernandez.runevo.ui.carrera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import gonzalez.hernandez.runevo.databinding.FragmentCarreraBinding

class CarreraFragment : Fragment() {

    private var _binding: FragmentCarreraBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val carreraViewModel =
            ViewModelProvider(this).get(CarreraViewModel::class.java)

        _binding = FragmentCarreraBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textCarrera
        carreraViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}