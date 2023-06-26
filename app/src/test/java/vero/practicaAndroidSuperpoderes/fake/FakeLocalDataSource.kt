package vero.practicaAndroidSuperpoderes.fake


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import vero.practicaAndroidSuperpoderes.data.local.LocalDataSource
import vero.practicaAndroidSuperpoderes.data.local.model.MarvelCharacterLocal
import vero.practicaAndroidSuperpoderes.flow.generateLocalCharactersFlow

class FakeLocalDataSource(private val shared: Boolean = false): LocalDataSource {
    private var firstCall = true

    private val sharedFlow = MutableSharedFlow<List<MarvelCharacterLocal>>()

    suspend fun emit(list: List<MarvelCharacterLocal>){
        sharedFlow.emit(list)
    }

    override fun getCharacters(): Flow<List<MarvelCharacterLocal>> {
        return if (shared) {
            sharedFlow
        } else {
            generateLocalCharactersFlow()
        }
    }

    override fun insertCharacters(characters: List<MarvelCharacterLocal>) {

    }

    override fun getNumberOfCharacters(): Int {
        return if (firstCall) {
            firstCall = false
            0
        }else {
            1
        }
    }

    override fun updateCharacter(character: MarvelCharacterLocal) {
        TODO("Not yet implemented")
    }

}