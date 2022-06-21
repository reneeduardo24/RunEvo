package com.hernandez.runevo.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hernandez.runevo.databinding.FragmentComunidadBinding
import com.hernandez.runevo.ui.ComunidadViewModel

class ComunidadFragment : Fragment() {

    private var _binding: FragmentComunidadBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val comunidadViewModel =
            ViewModelProvider(this).get(ComunidadViewModel::class.java)

        _binding = FragmentComunidadBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}