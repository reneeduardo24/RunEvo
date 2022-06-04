package gonzalez.hernandez.runevo.ui.historial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistorialViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Esta será la pantalla de historial"
    }
    val text: LiveData<String> = _text
}