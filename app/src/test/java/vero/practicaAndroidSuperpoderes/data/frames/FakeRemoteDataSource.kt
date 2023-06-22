package vero.practicaAndroidSuperpoderes.data.frames

import vero.practicaAndroidSuperpoderes.data.remote.RemoteDataSource
import vero.practicaAndroidSuperpoderes.domain.model.Hero

class FakeRemoteDataSource: RemoteDataSource {
    override suspend fun login(user: String, password: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun getHeros(): List<Hero> {
        TODO("Not yet implemented")
    }
}