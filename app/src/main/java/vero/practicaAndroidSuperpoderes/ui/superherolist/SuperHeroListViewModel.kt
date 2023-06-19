package vero.practicaAndroidSuperpoderes.ui.superherolist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import vero.practicaAndroidSuperpoderes.data.Repository
import vero.practicaAndroidSuperpoderes.domain.model.Hero
import javax.inject.Inject

@HiltViewModel //es un framewqork de inyeccion de dependecncias . El repository es una implementacion
//hay que depender de la abstraccion y no de la implementacion. Ya sea por testing, cambiar Room por Realt o servidor de prod por otroo servidor de staging
class SuperHeroListViewModel @Inject constructor(private val repository: Repository): ViewModel() {


    private val _state = MutableStateFlow<List<Hero>>(emptyList())
    val state: StateFlow<List<Hero>> get() = _state


    fun getSuperheros() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){//ejecutamos en segundo plano con el Dispatcher
                repository.getHeros()
            }

            _state.update { result }
        }
    }
}

