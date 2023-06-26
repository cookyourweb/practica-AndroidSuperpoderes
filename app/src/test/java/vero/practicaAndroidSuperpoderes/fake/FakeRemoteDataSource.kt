package vero.practicaAndroidSuperpoderes.fake

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import vero.practicaAndroidSuperpoderes.data.remote.MarvelResponse
import vero.practicaAndroidSuperpoderes.data.remote.RemoteDataSource
import vero.practicaAndroidSuperpoderes.flow.generateFakeMarvelResponse

class FakeRemoteDataSource() : RemoteDataSource {


    private val marvelResponseFake = generateFakeMarvelResponse()

    override suspend fun getCharacters(): MarvelResponse {
        return marvelResponseFake
    }

    override suspend fun getSeries(characterId: Int): Flow<MarvelResponse> {
        return flow { emit(marvelResponseFake)  }
    }

    override suspend fun getComics(characterId: Int): Flow<MarvelResponse> {
        return  flow { emit(marvelResponseFake) }
    }

}