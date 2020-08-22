package com.jsevilla.movieviewer.feature.ui.fragment.detail

import android.os.Bundle
import android.view.View
import com.jsevilla.movieviewer.BR
import com.jsevilla.movieviewer.R
import com.jsevilla.movieviewer.databinding.FragmentMovieListBinding
import com.jsevilla.movieviewer.feature.base.BaseFragment
import com.jsevilla.movieviewer.model.MovieModel

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class MovieDetailFragment :
    BaseFragment<FragmentMovieListBinding, MovieDetailViewModel>(MovieDetailViewModel::class) {

    override val getLayoutId: Int
        get() = R.layout.fragment_movie_detail

    override val getBindingVariable: Int
        get() = BR.movieDetailViewModel

    override fun onFragmentViewReady(view: View) {
        myViewModel.getValuesFromArguments(arguments?.getParcelable("movieModel"))
    }

    companion object {
        fun newInstance(model: MovieModel) = MovieDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("movieModel", model)
            }
        }
    }
}
