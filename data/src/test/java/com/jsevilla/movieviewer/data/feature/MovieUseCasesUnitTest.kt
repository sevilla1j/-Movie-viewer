package com.jsevilla.movieviewer.data.feature

import com.jsevilla.movieviewer.data.base.BaseUseCaseUniTest
import com.jsevilla.movieviewer.domain.usecase.GetMovieListUseCase
import com.jsevilla.movieviewer.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.test.inject

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class MovieUseCasesUnitTest : BaseUseCaseUniTest() {

    private val getMovieListUseCase by inject<GetMovieListUseCase>()
    private val getMovieUseCase by inject<GetMovieUseCase>()

    @Test
    fun `GET TODO LIST`() = runBlocking {
        getMovieListUseCase.invoke(this, Any()) {
            it.either(::printUseCaseFailure, ::printUseCaseSuccessList)
        }
    }

    @Test
    fun `GET TODO object of id 1`() = runBlocking {
        val params = GetMovieUseCase.Params(605116) // Id of Project Power
        getMovieUseCase.invoke(this, params) {
            it.either(::printUseCaseFailure, ::printUseCaseSuccessObject)
        }
    }
}
