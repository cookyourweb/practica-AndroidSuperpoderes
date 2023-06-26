package vero.practicaAndroidSuperpoderes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import vero.practicaAndroidSuperpoderes.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class SuperheroDatabase : RoomDatabase() {
abstract fun superheroDao(): SuperheroDAO
}
