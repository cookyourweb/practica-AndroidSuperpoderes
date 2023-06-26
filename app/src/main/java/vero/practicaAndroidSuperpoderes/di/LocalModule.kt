package vero.practicaAndroidSuperpoderes.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import vero.practicaAndroidSuperpoderes.data.local.MarvelCharacterDao
import vero.practicaAndroidSuperpoderes.data.local.MarvelCharacterDatabase

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MarvelCharacterDatabase {
        return Room.databaseBuilder(
            context,
            MarvelCharacterDatabase::class.java, "marvel-db"
        )
            .build()
    }

    @Provides
    fun provideDao(database: MarvelCharacterDatabase): MarvelCharacterDao {
        return database.getDao()
    }
}
