package vero.practicaAndroidSuperpoderes.data.remote


import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import vero.practicaAndroidSuperpoderes.data.remote.request.GetHerosRequest
import vero.practicaAndroidSuperpoderes.domain.model.Hero

interface DragonBallApi {
    @POST("api/auth/login")
    suspend fun login(@Header("Authorization") token: String): String

    @POST("api/heros/all")
    suspend fun getHeros(@Header("Authorization") token: String, @Body getHerosRequest: GetHerosRequest): List<Hero>
}
