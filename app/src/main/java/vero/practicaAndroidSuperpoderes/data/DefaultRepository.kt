package vero.practicaAndroidSuperpoderes.data


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import okhttp3.Credentials
import vero.practicaAndroidSuperpoderes.data.local.LocalDataSource

import vero.practicaAndroidSuperpoderes.data.mappers.RemoteToLocalMapper
import vero.practicaAndroidSuperpoderes.data.remote.RemoteDataSource

import vero.practicaAndroidSuperpoderes.domain.model.MarvelCharacter
import vero.practicaAndroidSuperpoderes.domain.model.MarvelSerie

import javax.inject.Inject
import javax.inject.Singleton

@Singleton

class DefaultRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val remoteToLocalMapper: RemoteToLocalMapper,
    private val localToPresentationMapper: LocalToPresentationMapper,
    private val remoteToPresentationMapper: RemoteToPresentationMapper

    ) : Repository {
    override suspend fun getCharactersSaved(): Flow<List<MarvelCharacter>> {

        if (localDataSource.getNumberOfCharacters()==0) {

            val remoteCharacters = remoteDataSource.getCharacters()

            localDataSource.insertCharacters(remoteToLocalMapper.map(remoteCharacters))
        }

        return localDataSource.getCharacters().map { localToPresentationMapper.map(it) }
    }

    override suspend fun setLike(character: MarvelCharacter) {
        localDataSource.updateCharacter(localToPresentationMapper.map(character))
    }

    override suspend fun getSeries(characterId: Int): Flow<List<MarvelSerie>> {
        return remoteDataSource.getSeries(characterId).map { remoteToPresentationMapper.mapSeries(it) }
    }

    override suspend fun getComics(characterId: Int): Flow<List<MarvelSerie>> {
        return remoteDataSource.getComics(characterId).map { remoteToPresentationMapper.mapSeries(it) }
    }

}



