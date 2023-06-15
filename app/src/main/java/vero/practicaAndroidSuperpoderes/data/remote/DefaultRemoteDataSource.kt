package vero.practicaAndroidSuperpoderes.data.remote


import okhttp3.Credentials
import vero.practicaAndroidSuperpoderes.data.remote.DragonBallApi
import vero.practicaAndroidSuperpoderes.data.remote.request.GetHerosRequest
import vero.practicaAndroidSuperpoderes.domain.model.Hero
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
//aqui le injectamos la  api y hay que  meter retrofit . Lo hacemos  en ell NetworkModule
class DefaultRemoteDataSource @Inject constructor(private val api: DragonBallApi) : RemoteDataSource {

    private lateinit var token: String
    override suspend fun login(user: String, password: String): String {
        val token = api.login(Credentials.basic(user, password))
        this.token = token

        return token
    }

    override suspend fun getHeros(): List<Hero> {
        return api.getHeros("Bearer $token", GetHerosRequest())
    }
}
