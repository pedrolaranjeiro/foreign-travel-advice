package uk.co.flat14.ftaa.presentation.viewmodels


import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import uk.co.flat14.ftaa.domain.interactor.GetCountriesUseCase
import uk.co.flat14.ftaa.domain.model.CountryInformation

class CountryListViewModel(
    private val getCountriesUseCase: GetCountriesUseCase
): ViewModel(){

    private val _uiState = MutableStateFlow(CountryListState.Success(emptyList()))
    val uiState : StateFlow<CountryListState> = _uiState.asStateFlow()

    init {
        getCountries()
    }

    fun getCountries() {
        getCountriesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                it
            }.
            doOnSuccess {
                _uiState.update {currentState ->
                    currentState.copy(countryInformationList = it)
                }
            }.subscribe()
    }
}

sealed interface  CountryListState{
    data object Loading: CountryListState

    data class Success(val countryInformationList: List<CountryInformation>): CountryListState
}
