package vero.practicaAndroidSuperpoderes.data

import vero.practicaAndroidSuperpoderes.domain.model.Hero


interface Repository {
    suspend fun login(user: String, password: String): String
    suspend fun getHeros(): List<Hero>
}
