package uk.co.flat14.ftaa.data.pictures

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UnsplashDataStore {
    fun getPictures(countryName: String): Flow<UnsplashPictureListResponse?> =  flow {

        val response = unsplashApi.getCountries(countryName).execute()
        if (response.isSuccessful) {
            emit(response.body())
        } else {
            throw Exception("Error: ${response.code()}")
        }
    }


}
