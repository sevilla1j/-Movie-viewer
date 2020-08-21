package com.jsevilla.movieviewer.domain.usecase

import com.jsevilla.movieviewer.domain.entity.Either
import com.jsevilla.movieviewer.domain.entity.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

abstract class BaseUseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    open operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) {
        val backgroundJob = scope.async(Dispatchers.IO) {
            run(params)
        }
        scope.launch {
            onResult(backgroundJob.await())
        }
    }
}