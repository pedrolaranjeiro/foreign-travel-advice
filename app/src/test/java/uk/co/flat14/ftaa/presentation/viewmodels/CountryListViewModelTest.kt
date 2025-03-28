package uk.co.flat14.ftaa.presentation.viewmodels


import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import uk.co.flat14.ftaa.domain.countries.CountryInformation
import uk.co.flat14.ftaa.domain.countries.GetCountriesUseCase


class CountryListViewModelTest{


  private val testScheduler = TestCoroutineScheduler()
  private val testDispatcher = StandardTestDispatcher(testScheduler)
  private val testScope = TestScope(testDispatcher + testScheduler)


  private lateinit var cut: CountryListViewModel

  private var useCaseMock = mockk<GetCountriesUseCase>()

  @Before
  fun setup(){
    cut = CountryListViewModel(useCaseMock)
  }

  @Test
  fun `initial state should be Loading`() = testScope.runTest {
    assertEquals(CountryListState.Loading, cut.uiState)
  }




  @Test
  fun `when get countries then update ui state`()= runTest{
    //val collectJob = launch (UnconfinedTestDispatcher()) {cut.uiState.collect()} }

    // Given
 //   every { useCaseMock.execute() } returns Single.just(emptyList())
    val expected = emptyList<CountryInformation>()

    // When
    val actual = cut.getCountries()

    //assertEquals(expected, actual)

  }



}
