package uk.co.flat14.ftaa.domain.interactor

import io.reactivex.Single
import uk.co.flat14.ftaa.data.RepositoryFactory
import uk.co.flat14.ftaa.domain.interactor.type.UseCase
import uk.co.flat14.ftaa.domain.model.Country
import uk.co.flat14.ftaa.domain.repository.CountryRepository

class GetCountriesUseCaseImpl: GetCountriesUseCase {

    private var countryRepository: CountryRepository = RepositoryFactory().getCountryRepository()

    override fun execute(): Single<List<Country>> {
        return countryRepository.getCountries()
                // Map the response to Entity model
                .map { response ->
                    val countryList = ArrayList<Country>()
                    for (child in response.links.children){
                        countryList.add(Country(child.country.name, child.webUrl))
                    }
                    countryList.toList()
                }
    }

}