package com.jsevilla.movieviewer.data.di

import com.jsevilla.movieviewer.data.network.mapper.MovieMapper
import com.jsevilla.movieviewer.data.network.mapper.MovieMapperImpl
import org.koin.dsl.module

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

val mapperDataModule = module {
    factory<MovieMapper> { MovieMapperImpl() }
}
