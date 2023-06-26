package vero.practicaAndroidSuperpoderes.ui.superherolist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import vero.practicaAndroidSuperpoderes.data.Repository
import vero.practicaAndroidSuperpoderes.domain.model.MarvelCharacter
import vero.practicaAndroidSuperpoderes.flow.generateCharactersFlow
import vero.practicaAndroidSuperpoderes.flow.generateListCharacters


@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListViewModelTest {


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    // SUT o UUT
    private lateinit var CharacterListViewModel: CharacterListViewModel

    // Dependencies
    private lateinit var repository: Repository

    private val mainThreadSubrrogate = newSingleThreadContext("UI thread")




    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSubrrogate)
    }


    @Test
    fun `WHen getCharacters expects list of characters`() = runTest {


        // GIVEN
        repository = mockk()
        coEvery { repository.getCharactersSaved() } returns generateCharactersFlow()
        CharacterListViewModel = CharacterListViewModel(repository)

        // WHEN
        val actualList = mutableListOf<List<MarvelCharacter>>()
        val collectJob = launch(UnconfinedTestDispatcher(testScheduler)) {
            CharacterListViewModel.characters.toList(actualList)
        }
        CharacterListViewModel.getCharacters()

        // THEN
        assert(
            actualList.size == 1
        )

        Truth.assertThat(actualList).containsAtLeastElementsIn(listOf(generateListCharacters()) )

        collectJob.cancel()
    }




    @After
    fun tearDown() {
    }

    @Test
    fun getCharacters() {
    }

    @Test
    fun testGetCharacters() {
    }

    @Test
    fun setLike() {
    }
}