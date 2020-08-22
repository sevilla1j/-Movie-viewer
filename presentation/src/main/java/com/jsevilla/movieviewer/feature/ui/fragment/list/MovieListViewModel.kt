package com.jsevilla.movieviewer.feature.ui.fragment.list

import androidx.lifecycle.*
import com.jsevilla.movieviewer.domain.entity.MovieEntity
import com.jsevilla.movieviewer.domain.usecase.GetMovieListUseCase
import com.jsevilla.movieviewer.feature.adapter.MovieAdapter
import com.jsevilla.movieviewer.feature.base.BaseViewModel
import com.jsevilla.movieviewer.mapper.MovieModelMapper
import com.jsevilla.movieviewer.model.MovieModel
import kotlinx.coroutines.Dispatchers

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class MovieListViewModel(
    private val getMovieListUseCase: GetMovieListUseCase,
    private val mapper: MovieModelMapper
) : BaseViewModel<MovieListNavigator>() {

    private val _movieList = MutableLiveData<List<MovieEntity>>()
    val movieList: LiveData<List<MovieModel>> = _movieList.switchMap {
        liveData(Dispatchers.IO) {
            emit(mapper.movieListDomainToPresentation(it))
        }
    }

    val adapter = MovieAdapter(arrayListOf()) { model, _ ->
        getNavigator()?.onMovieObjectClick(movie = model)
    }

    init {
        executeGetMovieListUseCase()
    }

    fun bindItemsAfterMapping(movieListMapped: List<MovieModel>) {
        setRefreshing(false)
        showLoading(false)
        shouldShowEmptyView(movieListMapped.isEmpty())
        showErrorCause(false)
        adapter.addItems(movieListMapped)
    }

    fun refreshData() {
        setRefreshing(true)
        executeGetMovieListUseCase()
    }

    private fun executeGetMovieListUseCase() {
        showLoading(true)
        getMovieListUseCase.invoke(viewModelScope, "") {
            it.either(::handleUseCaseFailureFromBase, ::handleUseCaseSuccess)
        }
    }

    private fun handleUseCaseSuccess(movie: List<MovieEntity>) {
        _movieList.value = movie
    }
}
