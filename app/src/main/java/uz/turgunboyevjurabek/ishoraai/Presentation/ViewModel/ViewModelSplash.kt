package uz.turgunboyevjurabek.ishoraai.Presentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ViewModelSplash:ViewModel() {
   private val _isReady= MutableStateFlow(false)
    var isReady=_isReady.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _isReady.value=true
        }
    }

}