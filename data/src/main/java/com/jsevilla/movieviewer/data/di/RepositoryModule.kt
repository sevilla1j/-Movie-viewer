package com.jsevilla.movieviewer.data.di

import com.jsevilla.movieviewer.data.repository.MovieRepositoryImpl
import com.jsevilla.movieviewer.domain.repository.MovieRepository
import org.koin.dsl.module

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

val repositoryModule = module {
    factory<MovieRepository> { MovieRepositoryImpl(get(), get()) }
}
