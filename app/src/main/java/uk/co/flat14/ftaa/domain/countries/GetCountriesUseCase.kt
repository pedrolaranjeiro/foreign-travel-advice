package uk.co.flat14.ftaa.domain.countries

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCountriesUseCase(private val countryRepository: CountryRepository){

    fun execute(): Flow<List<CountryInformation>> {
        return countryRepository.getCountries()
            // Map the response to Entity model
            .map { response ->
                val countryInformationList = arrayListOf<CountryInformation>()
                response?.links?.children?.map {
                    countryInformationList.add(
                        CountryInformation(
                            name = it.details.country.name,
                            details = it.details.latestDescription,
                            webUrl = it.webUrl
                        )
                    )
                }
                countryInformationList.shuffled()
            }
    }

}
