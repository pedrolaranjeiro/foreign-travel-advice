package uk.co.flat14.ftaa.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import uk.co.flat14.ftaa.data.CountryRepositoryImpl
import uk.co.flat14.ftaa.data.RemoteCountryDataStore
import uk.co.flat14.ftaa.domain.interactor.GetCountriesUseCase
import uk.co.flat14.ftaa.domain.interactor.GetCountriesUseCaseImpl
import uk.co.flat14.ftaa.domain.repository.CountryRepository
import uk.co.flat14.ftaa.presentation.viewmodels.CountryListViewModel

val dataModule = module {
    singleOf(::RemoteCountryDataStore)

    single<CountryRepository>{
        CountryRepositoryImpl(get())
    }
}
val domainModule = module {
    single<GetCountriesUseCase>{
        GetCountriesUseCaseImpl(get())
    }
}
val appModule = module {
    viewModelOf(::CountryListViewModel)
}
