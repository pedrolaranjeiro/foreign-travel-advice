package uk.co.flat14.ftaa.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import uk.co.flat14.ftaa.domain.countries.CountryInformation
import uk.co.flat14.ftaa.domain.countries.GetCountriesUseCase

class CountryListViewModel(
    private val getCountriesUseCase: GetCountriesUseCase
): ViewModel(){

    private val _uiState = MutableStateFlow<CountryListState>(CountryListState.Loading)
    val uiState : StateFlow<CountryListState> = _uiState.asStateFlow()

    init {
        getCountries()
    }

    fun getCountries() {
        viewModelScope.launch {
            getCountriesUseCase.execute()
                .flowOn(Dispatchers.IO)
                .collect {
                _uiState.value = CountryListState.Success(it)
            }
        }
    }


}

sealed interface CountryListState {

    data object Loading : CountryListState

    data class Success(val countryInformationList: List<CountryInformation>) : CountryListState

}
