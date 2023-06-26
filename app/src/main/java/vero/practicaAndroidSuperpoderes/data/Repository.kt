package vero.practicaAndroidSuperpoderes.data

import kotlinx.coroutines.flow.Flow
import vero.practicaAndroidSuperpoderes.domain.model.MarvelCharacter
import vero.practicaAndroidSuperpoderes.domain.model.MarvelSerie


interface Repository {
    suspend fun getCharactersSaved(): Flow<List<MarvelCharacter>>
    suspend fun setLike(character: MarvelCharacter)
    suspend fun getSeries(characterId:Int): Flow<List<MarvelSerie>>
    suspend fun getComics(characterId: Int): Flow<List<MarvelSerie>>
}

