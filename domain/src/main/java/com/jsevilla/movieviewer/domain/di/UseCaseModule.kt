package com.jsevilla.movieviewer.domain.di

import com.jsevilla.movieviewer.domain.usecase.GetMovieListUseCase
import org.koin.dsl.module

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

val useCasesModule = module {
    factory { GetMovieListUseCase(get()) }
}
