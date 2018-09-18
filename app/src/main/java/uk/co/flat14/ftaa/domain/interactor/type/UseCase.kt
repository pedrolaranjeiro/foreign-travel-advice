package uk.co.flat14.ftaa.domain.interactor.type

import io.reactivex.Single

interface UseCase<R> {

    fun execute (): Single<R>

}