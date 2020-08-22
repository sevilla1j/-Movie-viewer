package com.jsevilla.movieviewer.feature.bindingtools

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

@BindingAdapter("setImageUri")
fun setImageUri(appCompatImageView: AppCompatImageView, url: String?) {
    Glide.with(appCompatImageView.context)
        .load(url)
        .into(appCompatImageView)
}
