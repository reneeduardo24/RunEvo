package gonzalez.hernandez.runevo.ui.trofeos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import gonzalez.hernandez.runevo.databinding.FragmentTrofeosBinding

class TrofeosFragment : Fragment() {

    private var _binding: FragmentTrofeosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val trofeosViewModel =
            ViewModelProvider(this).get(TrofeosViewModel::class.java)

        _binding = FragmentTrofeosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTrofeos
        trofeosViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}