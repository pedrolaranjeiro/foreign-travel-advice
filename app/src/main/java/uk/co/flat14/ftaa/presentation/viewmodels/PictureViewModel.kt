package uk.co.flat14.ftaa.presentation.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import uk.co.flat14.ftaa.domain.pictures.CountryPictures
import uk.co.flat14.ftaa.domain.pictures.GetPicsForCountryUseCase


class PictureViewModel(
    private val getPicturesForCountryUseCase: GetPicsForCountryUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<PictureListState>(PictureListState.Loading)
    val uiState: StateFlow<PictureListState> = _uiState.asStateFlow()

    fun getPictures(countryName: String) {
        viewModelScope.launch {
            getPicturesForCountryUseCase.execute(countryName).flowOn(
                Dispatchers.IO
            ).collect{
                _uiState.value = PictureListState.Success(it)
            }
        }
    }

}

sealed interface PictureListState {
    data object Loading : PictureListState
    data class Success(val countryPictures: CountryPictures) : PictureListState

}
