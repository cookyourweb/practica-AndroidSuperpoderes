package vero.practicaAndroidSuperpoderes.data

import app.cash.turbine.test
import io.mockk.mockk
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import vero.practicaAndroidSuperpoderes.data.frames.FakeDao
import vero.practicaAndroidSuperpoderes.data.local.SuperheroDAO
import vero.practicaAndroidSuperpoderes.data.remote.RemoteDataSource
import vero.practicaAndroidSuperpoderes.domain.model.Hero

class DefaultRepositoryTest {

    //SUT
    private lateinit var defaultRepository: DefaultRepository  //fake



    // DEPENDENCIES
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var dao: SuperheroDAO


    @Before
    fun setUp() {

    }

    //run test lo necesitamos para tener el contexto de Corritina, el conntexto de función de suspension y que pudiesemos hacer cosas alli


//libreria de turbine

    @Test
    fun `(TURBINE VERSION) WHEN getLocalHeros successful EXPECTS list not empty and closed flow`() = runTest{
        // GIVEN
        remoteDataSource = mockk()
        dao = FakeDao(false)

        defaultRepository = DefaultRepository(remoteDataSource, dao)

        // WHEN
        val actual = defaultRepository.getLocalHeros()


        // THEN
        actual.test {
            val item1 = awaitItem()
            assert(item1.isNotEmpty())

            val item2 = awaitItem()
            assert(item2.isNotEmpty())

            awaitComplete()
        }
    }

        @Test
        fun `(TURBINE VERSION) WHEN getLocalHeros successful EXPECTS list not empty`() = runTest{
            // GIVEN
            remoteDataSource = mockk()
            dao = FakeDao(true)

            defaultRepository = DefaultRepository(remoteDataSource, dao)

            // WHEN
            val actual = defaultRepository.getLocalHeros()


            // THEN
            actual.test {
                (dao as FakeDao).emit(listOf(Hero("id", "name", "photo")))
                val item1 = awaitItem()
                assert(item1.isNotEmpty())

                (dao as FakeDao).emit(listOf(Hero("id1", "name1", "photo1")))
                val item2 = awaitItem()
                assert(item2.isNotEmpty())
            }
        }









    @After
    fun tearDown() {
    }
}