package com.hernandez.runevo.ui.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hernandez.runevo.R
import com.hernandez.runevo.databinding.FragmentSettingsBinding
import com.hernandez.runevo.util.Constants.KEY_NAME
import com.hernandez.runevo.util.Constants.KEY_WEIGHT
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textview.MaterialTextView
import com.hernandez.runevo.Configuration
import com.hernandez.runevo.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val bind = FragmentSettingsBinding.inflate(layoutInflater)

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        /* se guarda hasta que ponga boton de config de nuevo
        bind.tvConfig.setOnClickListener {
            val intent = Intent(this@SettingsFragment.requireContext(), Configuration::class.java)
            startActivity(intent)
        }
        */


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFieldsFromSharedPref()
        binding.btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPref()
            if (success) {
                Snackbar.make(view, "Cambios guardados", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(view, "Por favor llena los datos", Snackbar.LENGTH_LONG).show()
            }
        }
    }


    private fun loadFieldsFromSharedPref() {
        val name = sharedPreferences.getString(KEY_NAME, "")
        val weight = sharedPreferences.getFloat(KEY_WEIGHT, 80f)
        binding.txtPerfilName.setText(name)
        binding.etName.setText(name)
        binding.etWeight.setText(weight.toString())

    }

    private fun applyChangesToSharedPref(): Boolean {
        val name = binding.etName.text.toString()
        val weight = binding.etWeight.text.toString()

        if (name.isEmpty() || weight.isEmpty()) {
            return false
        }

        sharedPreferences.edit()
            .putString(KEY_NAME, name)
            .putFloat(KEY_WEIGHT, weight.toFloat())
            .apply()

        val toolbarText = "Vamos, $name!"
        (requireActivity().findViewById(R.id.tvToolbarTitle) as MaterialTextView).text = toolbarText
        return true
    }

    override fun onDestroyView() {
        _binding = null // Don't forget to recycle it or memory leaked.
        super.onDestroyView()
    }
}