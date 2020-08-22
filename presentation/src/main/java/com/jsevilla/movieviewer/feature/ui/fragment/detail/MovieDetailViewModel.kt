package com.jsevilla.movieviewer.feature.ui.fragment.detail

import androidx.lifecycle.*
import com.jsevilla.movieviewer.domain.entity.MovieEntity
import com.jsevilla.movieviewer.domain.usecase.GetMovieUseCase
import com.jsevilla.movieviewer.feature.base.BaseViewModel
import com.jsevilla.movieviewer.mapper.MovieModelMapper
import com.jsevilla.movieviewer.model.MovieModel
import kotlinx.coroutines.Dispatchers

/**
 * Created by Jose Sevilla on 21/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class MovieDetailViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val mapper: MovieModelMapper
) : BaseViewModel<Any>() {

    private var _movieId = -1L

    private val _movieModelFromNetwork = MutableLiveData<MovieEntity>()
    val movieModelFromNetwork: LiveData<MovieModel> = _movieModelFromNetwork.switchMap {
        liveData(Dispatchers.IO) {
            emit(mapper.movieDomainToPresentation(it))
        }
    }

    fun refreshData() {
        setRefreshing(false)
        executeGetMoviePerIdUseCase()
    }

    fun getValuesFromArguments(movieModel: MovieModel?) {
        _movieId = movieModel?.id ?: -1
        executeGetMoviePerIdUseCase()
    }

    private fun executeGetMoviePerIdUseCase() {
        showLoading(true)
        val params = GetMovieUseCase.Params(_movieId.toInt())
        getMovieUseCase.invoke(viewModelScope, params) {
            it.either(::handleUseCaseFailureFromBase, ::handleUseCaseSuccess)
        }
    }

    private fun handleUseCaseSuccess(movieEntity: MovieEntity) {
        _movieModelFromNetwork.value = movieEntity
        showLoading(false)
        shouldShowEmptyView(false)
        showErrorCause(false)
    }
}
