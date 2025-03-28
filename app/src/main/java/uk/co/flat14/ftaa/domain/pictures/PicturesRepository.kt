package uk.co.flat14.ftaa.domain.pictures

import kotlinx.coroutines.flow.Flow

interface PicturesRepository {

    fun getPictures(countryName: String) : Flow<CountryPictures>

}
