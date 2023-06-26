package vero.practicaAndroidSuperpoderes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import vero.practicaAndroidSuperpoderes.data.local.model.MarvelCharacterLocal

@Dao


interface MarvelCharacterDao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Flow<List<MarvelCharacterLocal>>

    @Insert(onConflict = REPLACE)
    fun insertAll(characters: List<MarvelCharacterLocal>)

    @Query("SElECT COUNT(id) FROM characters")
    fun getNumberOfCharacters():Int

    @Update
    fun updateCharacter(character: MarvelCharacterLocal)
}