package vero.practicaAndroidSuperpoderes.data.local

import vero.practicaAndroidSuperpoderes.data.local.model.MarvelCharacterLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultLocalDataSource @Inject constructor(
    private val dao:MarvelCharacterDao
): LocalDataSource {
    override fun getCharacters(): Flow<List<MarvelCharacterLocal>> {
        return dao.getAllCharacters()
    }

    override fun insertCharacters(characters: List<MarvelCharacterLocal>) {
        dao.insertAll(characters)
    }

    override fun getNumberOfCharacters(): Int {
        return dao.getNumberOfCharacters()
    }

    override fun updateCharacter(character: MarvelCharacterLocal) {
        dao.updateCharacter(character)
    }
}