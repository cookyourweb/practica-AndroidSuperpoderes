package vero.practicaAndroidSuperpoderes.data


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import okhttp3.Credentials
import vero.practicaAndroidSuperpoderes.data.local.SuperheroDAO
import vero.practicaAndroidSuperpoderes.data.remote.RemoteDataSource
import vero.practicaAndroidSuperpoderes.domain.model.Hero

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//aqui  le decimos que intente injectar una abstraccion, pero comoo el remoteDatasource no tiene ninguna inyeccion ni abstraccion
//para eso utilizamos el repository module que hace el binding
class DefaultRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dao: SuperheroDAO

    ) : Repository {
    override suspend fun login(user: String, password: String): String {
        return remoteDataSource.login(user, password)
    }

    override suspend fun getHeros(): List<Hero> {
        return remoteDataSource.getHeros()
    }
    override suspend fun getLocalHeros(): Flow<List<Hero>> {
        return dao.getAllFlow() //operacion reactiva sobre una lista para convertir a flow
       // return listOf(dao.getAll()).asFlow()


    }
    override suspend fun insertHero(hero: Hero) {
        //no depende de nada de  flow, lo mete en la bbdd directamemnte
        dao.insertAllVararg(hero)
    }
}
