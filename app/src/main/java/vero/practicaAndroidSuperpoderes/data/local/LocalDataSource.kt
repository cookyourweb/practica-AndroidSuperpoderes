package vero.practicaAndroidSuperpoderes.data.local

import kotlinx.coroutines.flow.Flow
import vero.practicaAndroidSuperpoderes.data.local.model.MarvelCharacterLocal

interface LocalDataSource {
    fun getCharacters(): Flow<List<MarvelCharacterLocal>>
    fun insertCharacters(characters: List<MarvelCharacterLocal>)
    fun getNumberOfCharacters():Int
    fun updateCharacter(character: MarvelCharacterLocal)
}