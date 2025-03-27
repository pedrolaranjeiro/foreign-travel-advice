package uk.co.flat14.ftaa.data

import io.reactivex.Single
import uk.co.flat14.ftaa.data.models.CountryListResponse

class RemoteCountryDataStore {
    
    fun getCountries(): Single<CountryListResponse> {
        return countryApi.getCountries()
    }
}
