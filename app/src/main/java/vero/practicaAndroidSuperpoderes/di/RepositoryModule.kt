package vero.practicaAndroidSuperpoderes.di


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vero.practicaAndroidSuperpoderes.data.DefaultRepository
import vero.practicaAndroidSuperpoderes.data.Repository
import vero.practicaAndroidSuperpoderes.data.remote.DefaultRemoteDataSource
import vero.practicaAndroidSuperpoderes.data.remote.RemoteDataSource

@InstallIn(SingletonComponent::class)
//este es el modulo que nos hace el binding
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(defaultRepository: DefaultRepository): Repository //a la abstraccion  Repoository le inyectamos la implementación. Solo hace falta cuando  tenemops implementacion

    @Binds
    abstract fun bindRemoteDataSource(defaultRemoteDataSource: DefaultRemoteDataSource): RemoteDataSource



    }

