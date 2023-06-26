package vero.practicaAndroidSuperpoderes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import vero.practicaAndroidSuperpoderes.data.local.model.MarvelCharacterLocal

@Database(entities = [MarvelCharacterLocal::class], version = 1)
abstract class MarvelCharacterDatabase: RoomDatabase() {
    abstract fun getDao():MarvelCharacterDao
}
