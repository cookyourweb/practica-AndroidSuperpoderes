package vero.practicaAndroidSuperpoderes.data

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import vero.practicaAndroidSuperpoderes.data.mappers.RemoteToLocalMapper
import vero.practicaAndroidSuperpoderes.fake.FakeLocalDataSource
import vero.practicaAndroidSuperpoderes.fake.FakeRemoteDataSource

//Con Fakes  podemoos  tener  implementaciones  reales  de las dependencias.
//Con Mocks si no necesitamos tanta
class DefaultRepositoryTest {

    //UUT  O SUT

    private lateinit var defaultRepository: DefaultRepository
    val fakeLocalDataSource = FakeLocalDataSource()
    val fakeRemoteDataSource  = FakeRemoteDataSource()
    val remoteToLocalMapper = RemoteToLocalMapper()
    val localToPresentationMapper = LocalToPresentationMapper()
    val remoteToPresentationMapper = RemoteToPresentationMapper()


    @Before
    fun setUp() {
        defaultRepository  = DefaultRepository(
            fakeLocalDataSource,
            fakeRemoteDataSource,
            remoteToLocalMapper,
            localToPresentationMapper,
            remoteToPresentationMapper


        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getCharactersSaved() {
    }

    @Test
    fun setLike() {
    }

    @Test
    fun getSeries() {
    }

    @Test
    fun `WHEN getComics get valid data`() = runTest {
        // GIVEN

        // WHEN
        val actual = defaultRepository.getComics(1).toList()

        // THEN
        assert(actual[0][0].title == "title")
    }

}
