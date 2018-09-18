package uk.co.flat14.ftaa.domain.interactor

class UseCaseFactory {

    fun getCountriesUseCase(): GetCountriesUseCase = GetCountriesUseCaseImpl()

}