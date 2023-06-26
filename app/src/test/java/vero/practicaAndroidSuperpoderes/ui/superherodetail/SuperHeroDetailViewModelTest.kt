package vero.practicaAndroidSuperpoderes.ui.superherodetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import vero.practicaAndroidSuperpoderes.data.Repository
import vero.practicaAndroidSuperpoderes.domain.model.MarvelSerie
import vero.practicaAndroidSuperpoderes.flow.generatSeriesFlow
import vero.practicaAndroidSuperpoderes.flow.generateListSeries
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroDetailViewModel

@OptIn(ExperimentalCoroutinesApi::class)
class SuperHeroDetailViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // SUT o UUT
    private lateinit var SuperHeroDetailViewModel: SuperHeroDetailViewModel

    // DEPENDENCIES

    private lateinit var repository: Repository

    private val mainThreadSubrrogate = newSingleThreadContext("THREAD UI")





    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSubrrogate)
    }


    @Test
    fun `When getSeries gets return valid list`() = runTest {
        // GIVEN
        repository = mockk()
        SuperHeroDetailViewModel = SuperHeroDetailViewModel(repository)
        coEvery { repository.getSeries(any()) } returns generatSeriesFlow()

        // WHEN
        SuperHeroDetailViewModel.getSeries(1)
        val actualList = mutableListOf<List<MarvelSerie>>()
        val collectJob = launch(UnconfinedTestDispatcher(testScheduler)) {
            SuperHeroDetailViewModel.series.toList(actualList)
        }


        assert(actualList.size == 1)

        Truth.assertThat(actualList).containsAtLeastElementsIn(listOf(
            generateListSeries()
        ) )

        collectJob.cancel()
    }




    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSubrrogate.close()
    }

}