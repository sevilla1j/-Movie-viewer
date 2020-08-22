package com.jsevilla.movieviewer.di

import com.jsevilla.movieviewer.mapper.MovieModelMapper
import com.jsevilla.movieviewer.mapper.MovieModelMapperImpl
import org.koin.dsl.module

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

val mapperPresentationModule = module {
    single<MovieModelMapper> { MovieModelMapperImpl() }
}
