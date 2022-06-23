package com.hernandez.runevo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComunidadViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Esta será la pantalla de comunidad"
    }
    val text: LiveData<String> = _text
}