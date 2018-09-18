package uk.co.flat14.ftaa.data

import io.reactivex.Single
import uk.co.flat14.ftaa.data.models.CountryListReponse
import uk.co.flat14.ftaa.domain.model.Country
import uk.co.flat14.ftaa.domain.repository.CountryRepository

class CountryRepositoryImpl: CountryRepository {

    override fun getCountries(): Single<CountryListReponse> {
        return countryApi.getCountries()
    }
}