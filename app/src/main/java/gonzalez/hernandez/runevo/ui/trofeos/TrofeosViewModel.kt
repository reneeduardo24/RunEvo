package gonzalez.hernandez.runevo.ui.trofeos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrofeosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Esta será la pantalla de trofeos"
    }
    val text: LiveData<String> = _text
}