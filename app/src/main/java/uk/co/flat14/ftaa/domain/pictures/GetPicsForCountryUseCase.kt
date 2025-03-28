package uk.co.flat14.ftaa.domain.pictures

import kotlinx.coroutines.flow.Flow

class GetPicsForCountryUseCase(private val picturesRepository: PicturesRepository){

    fun execute(countryName: String): Flow<CountryPictures> {
        return picturesRepository.getPictures(countryName)
    }

}
