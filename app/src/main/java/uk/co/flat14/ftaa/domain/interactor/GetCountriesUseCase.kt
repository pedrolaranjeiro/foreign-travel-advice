package uk.co.flat14.ftaa.domain.interactor

import uk.co.flat14.ftaa.domain.interactor.type.UseCase
import uk.co.flat14.ftaa.domain.model.Country

interface GetCountriesUseCase: UseCase<List<Country>>