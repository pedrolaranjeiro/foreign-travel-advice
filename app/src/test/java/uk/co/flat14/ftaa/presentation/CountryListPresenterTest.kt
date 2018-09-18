package uk.co.flat14.ftaa.presentation

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import uk.co.flat14.ftaa.domain.model.Country
import io.reactivex.Single
import io.reactivex.plugins.RxJavaPlugins
import org.mockito.Mock
import uk.co.flat14.ftaa.domain.interactor.GetCountriesUseCase
import uk.co.flat14.ftaa.domain.interactor.UseCaseFactory
import uk.co.flat14.ftaa.domain.repository.CountryRepository

class CountryListPresenterTest {



    @Before
    fun setupClass() {
        RxAndroidPlugins.reset()
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler {
            Schedulers.trampoline()
        }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            Schedulers.trampoline()
        }
    }

    @Test
    fun getCountriesIsSuccessful() {
        // Given
        val listView = Mockito.mock(CountryListView::class.java)
        val useCase = Mockito.mock(GetCountriesUseCase::class.java)
        val presenter = CountryListPresenter(listView)
        presenter.countriesUseCase = useCase

        val expectedResult = ArrayList<Country>()
        Mockito.`when`(useCase.execute()).thenReturn(Single.just(expectedResult))

        // When
        presenter.getCountries()

        // Then
        verify(listView).setCountries(expectedResult)
    }
}
