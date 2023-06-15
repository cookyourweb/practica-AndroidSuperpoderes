package vero.practicaAndroidSuperpoderes.data.remote

import vero.practicaAndroidSuperpoderes.domain.model.Hero


interface RemoteDataSource {

    suspend fun login(user: String, password: String): String
    suspend fun getHeros(): List<Hero>
}
