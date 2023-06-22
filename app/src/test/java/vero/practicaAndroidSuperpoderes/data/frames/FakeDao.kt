package vero.practicaAndroidSuperpoderes.data.frames

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import vero.practicaAndroidSuperpoderes.data.local.SuperheroDAO
import vero.practicaAndroidSuperpoderes.domain.model.Hero

class FakeDao (private val shared: Boolean) : SuperheroDAO{


    private val heros = flow {
        emit(listOf(Hero("id", "name", "photo", isFavorite = false)))
        emit(listOf(Hero("id1", "name1", "photo1", isFavorite= false)))
    }


    //los shared flows permiten dejar abierto el canal .Quien te esté escuchando que reciba este dato.
    //es lo que notifica el room

    private val sharedHeros = MutableSharedFlow<List<Hero>>()

    suspend fun emit(heros: List<Hero>) {
        sharedHeros.emit(heros)
    }

    override suspend fun getAll(): List<Hero> {
        TODO("Not yet implemented")
    }

    override fun getAllFlow(): Flow<List<Hero>> {
        return if (shared) {
            sharedHeros
        } else {
            heros
        }
    }

    override suspend fun insertAllVararg(vararg users: Hero) {
        TODO("Not yet implemented")
    }

    override suspend fun insertAllList(users: List<Hero>) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(user: Hero) {
        TODO("Not yet implemented")
    }
}