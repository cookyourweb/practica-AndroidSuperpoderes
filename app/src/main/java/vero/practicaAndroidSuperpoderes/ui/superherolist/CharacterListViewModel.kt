package vero.practicaAndroidSuperpoderes.ui.superherolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

import vero.practicaAndroidSuperpoderes.data.Repository
import vero.practicaAndroidSuperpoderes.domain.model.MarvelCharacter
import javax.inject.Inject

@HiltViewModel //es un framewqork de inyeccion de dependecncias . El repository es una implementacion
//hay que depender de la abstraccion y no de la implementacion. Ya sea por testing, cambiar Room por Realt o servidor de prod por otroo servidor de staging
class CharacterListViewModel @Inject constructor(private val repository: Repository): ViewModel() {


    private val _characters = MutableStateFlow(emptyList<MarvelCharacter>())
    val characters: StateFlow<List<MarvelCharacter>> get() = _characters

    init {
        getCharacters()
    }

    fun getCharacters() {

        viewModelScope.launch(Dispatchers.IO) {

            repository.getCharactersSaved().flowOn(Dispatchers.IO).collect {
//                Log.d(TAG, it.toString())
                _characters.value = it
            }

        }
    }

    fun setLike(character: MarvelCharacter){

//        character.isFavorite = isFavorite

        viewModelScope.launch(Dispatchers.IO) {

            repository.setLike(character)
        }
    }

}