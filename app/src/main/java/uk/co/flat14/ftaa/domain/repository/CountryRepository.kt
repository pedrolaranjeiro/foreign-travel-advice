package uk.co.flat14.ftaa.domain.repository

import io.reactivex.Single
import uk.co.flat14.ftaa.data.models.CountryListReponse

interface CountryRepository {

    fun getCountries() : Single<CountryListReponse>

}