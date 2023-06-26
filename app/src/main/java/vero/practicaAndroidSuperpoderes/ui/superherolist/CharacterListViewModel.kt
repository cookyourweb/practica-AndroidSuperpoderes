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
import vero.practicaAndroidSuperpoderes.domain.model.MarvelCharacter
import javax.inject.Inject

@HiltViewModel //es un framewqork de inyeccion de dependecncias . El repository es una implementacion
//hay que depender de la abstraccion y no de la implementacion. Ya sea por testing, cambiar Room por Realt o servidor de prod por otroo servidor de staging
class SuperHeroListViewModel @Inject constructor(private val repository: Repository): ViewModel() {


    private val _state = MutableStateFlow<List<MarvelCharacter>>(emptyList())
    val state: StateFlow<List<MarvelCharacter>>
    get() = _state

//creamos un contador.El statflow lo exponemos en el compose.  Para mejorar crear difererentes capas entre los modelos de datos
    //el  flow que recibo del repositorio lo almaceno aqui:
private val _favs = MutableStateFlow(0)
    val favs: StateFlow<Int> get() = _favs

    fun getSuperheros() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){//ejecutamos en segundo plano con el Dispatcher
                repository.getHeros()
            }

            _state.update { result }
            //actualizamos la variable. Como vamos a salir afuera para leer la bd utilizamos el Dispatchers.
            //como no devuelve resultado lo puedo poner en el launch
            launch(Dispatchers.IO){
                repository.getLocalHeros().collect{ heros ->
                    _favs.update {  heros.size }//para que me diga cuantos hay
                }
            }
        }
    }

    fun insertSuperhero(hero:MarvelCharacter){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertHero(hero)

           /* val result = withContext(Dispatchers.IO){
                repository.getLocalHeros()*/
            }
        }
    }


