package com.jsevilla.movieviewer.di

import com.jsevilla.movieviewer.feature.ui.fragment.detail.MovieDetailViewModel
import com.jsevilla.movieviewer.feature.ui.fragment.list.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

val viewModelModule = module {
    viewModel { MovieListViewModel(get(), get()) }
    viewModel { MovieDetailViewModel(get(), get()) }
}
