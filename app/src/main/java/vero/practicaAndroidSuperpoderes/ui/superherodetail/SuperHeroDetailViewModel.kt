package vero.practicaAndroidSuperpoderes.ui.superherolist

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

@HiltViewModel
class SuperHeroDetailViewModel @Inject constructor(private val repository: Repository): ViewModel() {


    private val _state = MutableStateFlow<List<Hero>>(emptyList())
    val state: StateFlow<List<Hero>>
    get() = _state


private val _favs = MutableStateFlow(0)
    val favs: StateFlow<Int> get() = _favs

    fun getSuperheros() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){//ejecutamos en segundo plano con el Dispatcher
                repository.getHeros()
            }

            _state.update { result }

            launch(Dispatchers.IO){
                repository.getLocalHeros().collect{ heros ->
                    _favs.update {  heros.size }//para que me diga cuantos hay
                }
            }
        }
    }

    fun insertSuperhero(hero:Hero){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertHero(hero)

            }
        }
    }


