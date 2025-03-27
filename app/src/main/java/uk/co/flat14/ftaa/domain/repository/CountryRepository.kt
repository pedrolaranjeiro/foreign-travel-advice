package uk.co.flat14.ftaa.domain.repository

import io.reactivex.Single
import uk.co.flat14.ftaa.data.models.CountryListResponse

interface CountryRepository {

    fun getCountries() : Single<CountryListResponse>

}
