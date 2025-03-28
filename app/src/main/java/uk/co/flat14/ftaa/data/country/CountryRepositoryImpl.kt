package uk.co.flat14.ftaa.data.country


import kotlinx.coroutines.flow.Flow
import uk.co.flat14.ftaa.domain.countries.CountryRepository

class CountryRepositoryImpl(private val dataStore: RemoteCountryDataStore): CountryRepository {

    override fun getCountries(): Flow<CountryListResponse?> = dataStore.getCountries()


}
