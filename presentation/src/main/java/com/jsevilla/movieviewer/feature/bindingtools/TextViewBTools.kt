package com.jsevilla.movieviewer.feature.bindingtools

import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

@BindingAdapter("setCustomErrorMessage")
fun setCustomErrorMessage(tv: AppCompatTextView, message: Any?) {
    tv.text = when (message) {
        is String -> message
        is Int -> tv.resources.getString(message)
        else -> ""
    }
}
