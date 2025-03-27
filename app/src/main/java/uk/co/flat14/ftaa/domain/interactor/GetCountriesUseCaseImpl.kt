package uk.co.flat14.ftaa.domain.interactor

import io.reactivex.Single
import uk.co.flat14.ftaa.domain.model.CountryInformation
import uk.co.flat14.ftaa.domain.repository.CountryRepository

class GetCountriesUseCaseImpl(private val countryRepository: CountryRepository) :
    GetCountriesUseCase {

    override fun execute(): Single<List<CountryInformation>> {
        return countryRepository.getCountries()
            // Map the response to Entity model
            .map { response ->
                val countryInformationList = arrayListOf<CountryInformation>()
                response.links.children.map {
                    countryInformationList.add(
                        CountryInformation(
                            name = it.details.country.name,
                            details = it.details.latestDescription,
                            webUrl = it.webUrl
                        )
                    )
                }
                countryInformationList.toList().sortedBy {
                    it.name
                }
            }
    }

}
