package uk.co.flat14.ftaa.data

import uk.co.flat14.ftaa.domain.repository.CountryRepository

class RepositoryFactory {

    fun getCountryRepository(): CountryRepository {
        return CountryRepositoryImpl()
    }

}