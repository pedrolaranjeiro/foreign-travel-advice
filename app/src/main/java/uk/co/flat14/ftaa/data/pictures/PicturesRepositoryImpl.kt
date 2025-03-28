package uk.co.flat14.ftaa.data.pictures

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uk.co.flat14.ftaa.domain.pictures.CountryPictures
import uk.co.flat14.ftaa.domain.pictures.PicturesRepository

class PicturesRepositoryImpl(private val unsplashDataStore: UnsplashDataStore): PicturesRepository {
    override fun getPictures(countryName: String): Flow<CountryPictures> {
        return unsplashDataStore.getPictures(countryName).map {
            val list = it?.results?.map {result ->
                result.urls.full
            } ?: emptyList()

            CountryPictures(
                name = countryName,
                picturesLinks = list)

        }
    }
}
