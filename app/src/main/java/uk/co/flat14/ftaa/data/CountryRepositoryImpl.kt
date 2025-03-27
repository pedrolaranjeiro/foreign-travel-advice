package uk.co.flat14.ftaa.data

import io.reactivex.Single
import uk.co.flat14.ftaa.data.models.CountryListResponse
import uk.co.flat14.ftaa.domain.repository.CountryRepository

class CountryRepositoryImpl(private val dataStore: RemoteCountryDataStore): CountryRepository {

    override fun getCountries(): Single<CountryListResponse> {
        return dataStore.getCountries()
    }
}
