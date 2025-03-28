package uk.co.flat14.ftaa.domain.countries

import kotlinx.coroutines.flow.Flow
import uk.co.flat14.ftaa.data.country.CountryListResponse

interface CountryRepository {

    fun getCountries() : Flow<CountryListResponse?>

}
