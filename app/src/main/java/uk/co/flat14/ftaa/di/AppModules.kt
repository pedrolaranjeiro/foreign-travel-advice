package uk.co.flat14.ftaa.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import uk.co.flat14.ftaa.data.country.CountryRepositoryImpl
import uk.co.flat14.ftaa.data.country.RemoteCountryDataStore
import uk.co.flat14.ftaa.data.pictures.PicturesRepositoryImpl
import uk.co.flat14.ftaa.data.pictures.UnsplashDataStore
import uk.co.flat14.ftaa.domain.countries.CountryRepository
import uk.co.flat14.ftaa.domain.countries.GetCountriesUseCase
import uk.co.flat14.ftaa.domain.pictures.GetPicsForCountryUseCase
import uk.co.flat14.ftaa.domain.pictures.PicturesRepository
import uk.co.flat14.ftaa.presentation.viewmodels.CountryListViewModel
import uk.co.flat14.ftaa.presentation.viewmodels.PictureViewModel

val dataModule = module {
    singleOf(::RemoteCountryDataStore)
    singleOf(::UnsplashDataStore)

    single<CountryRepository>{
        CountryRepositoryImpl(get())
    }

    single<PicturesRepository>{
        PicturesRepositoryImpl(get())
    }


}
val domainModule = module {
    singleOf(::GetCountriesUseCase)
    singleOf(::GetPicsForCountryUseCase)

}
val appModule = module {
    viewModelOf(::CountryListViewModel)
    viewModelOf(::PictureViewModel)

}
