package vero.practicaAndroidSuperpoderes.data


import okhttp3.Credentials
import vero.practicaAndroidSuperpoderes.data.remote.RemoteDataSource
import vero.practicaAndroidSuperpoderes.domain.model.Hero
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//aqui  le decimos que intente injectar una abstraccion, pero comoo el remoteDatasource no tiene ninguna inyeccion ni abstraccion
//para eso utilizamos el repository module que hace el binding
class DefaultRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) : Repository {
    override suspend fun login(user: String, password: String): String {
        return remoteDataSource.login(user, password)
    }

    override suspend fun getHeros(): List<Hero> {
        return remoteDataSource.getHeros()
    }
}
