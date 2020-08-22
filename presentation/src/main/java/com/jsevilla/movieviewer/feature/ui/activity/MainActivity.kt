package com.jsevilla.movieviewer.feature.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jsevilla.movieviewer.R
import com.jsevilla.movieviewer.feature.ui.fragment.list.MovieListFragment

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_main, MovieListFragment())
            .commit()
    }
}
