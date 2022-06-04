package gonzalez.hernandez.runevo.ui.carrera

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CarreraViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Esta será la pantalla de carrera"
    }
    val text: LiveData<String> = _text
}