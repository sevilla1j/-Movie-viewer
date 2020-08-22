package com.jsevilla.movieviewer.feature.ui.fragment.list

import android.view.View
import androidx.lifecycle.Observer
import com.jsevilla.movieviewer.BR
import com.jsevilla.movieviewer.R
import com.jsevilla.movieviewer.databinding.FragmentMovieListBinding
import com.jsevilla.movieviewer.feature.base.BaseFragment
import com.jsevilla.movieviewer.feature.ui.fragment.detail.MovieDetailFragment
import com.jsevilla.movieviewer.model.MovieModel

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class MovieListFragment :
    BaseFragment<FragmentMovieListBinding, MovieListViewModel>(MovieListViewModel::class),
    MovieListNavigator {

    override val getLayoutId: Int
        get() = R.layout.fragment_movie_list

    override val getBindingVariable: Int
        get() = BR.viewModel

    override fun onFragmentViewReady(view: View) {
        myViewModel.setNavigator(this)
        myViewModel.movieList.observe(this, Observer {
            myViewModel.bindItemsAfterMapping(it)
        })
    }

    override fun onMovieObjectClick(movie: MovieModel) {
        addFragment(R.id.frame_main, MovieDetailFragment.newInstance(movie), true)
    }
}
