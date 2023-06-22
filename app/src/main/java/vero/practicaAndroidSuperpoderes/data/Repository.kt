package vero.practicaAndroidSuperpoderes.data

import kotlinx.coroutines.flow.Flow
import vero.practicaAndroidSuperpoderes.domain.model.Hero


interface Repository {
    suspend fun login(user: String, password: String): String
    suspend fun getHeros(): List<Hero>
    suspend fun getLocalHeros(): Flow<List<Hero>> //Flow nos permite meter la lista asi. ES reaccomo tengo una abstraccion se añaden aqui ya que depende del viewmodel
    suspend fun insertHero(hero: Hero)
}

