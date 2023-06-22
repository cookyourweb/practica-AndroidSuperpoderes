package vero.practicaAndroidSuperpoderes.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vero.practicaAndroidSuperpoderes.domain.model.Hero

@Dao

//Esto lo usamos en el localDataSource. Aunque vamos a hacer un mapeo en el Repository directamente
interface SuperheroDAO {
    @Query("SELECT * FROM superheros")
    suspend fun getAll(): List<Hero>

    @Query("SELECT * FROM superheros")
    fun getAllFlow(): Flow<List<Hero>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVararg(vararg users: Hero)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllList(users: List<Hero>)

    @Delete
    suspend fun delete(user: Hero)
}
