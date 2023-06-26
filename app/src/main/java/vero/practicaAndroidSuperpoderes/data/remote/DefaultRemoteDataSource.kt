package vero.practicaAndroidSuperpoderes.data.remote


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//con el Singleton no necesitmaos guardar los datos a local
//aqui le injectamos la  api y hay que  meter retrofit . Lo hacemos  en ell NetworkModule
class DefaultRemoteDataSource  @Inject constructor(private val api: MarvelAPI): RemoteDataSource  {
    override suspend fun getCharacters(): MarvelResponse {
        return api.getCharacters()
    }

    override suspend fun getSeries(characterId: Int): Flow<MarvelResponse> {
        return flow { emit(api.getSeries(characterId)) }
    }

    override suspend fun getComics(characterId: Int): Flow<MarvelResponse> {
        return flow { emit(api.getComics(characterId)) }
    }
}
