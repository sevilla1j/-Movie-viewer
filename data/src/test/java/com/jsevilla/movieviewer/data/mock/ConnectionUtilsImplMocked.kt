package com.jsevilla.movieviewer.data.mock

import com.jsevilla.movieviewer.data.core.ConnectionUtils

/**
 * Created by Jose Sevilla on 20/08/2020.
 * jose1.sevilla23@gmail.com
 *
 * Movie Viewer
 * Lima, Peru.
 **/

class ConnectionUtilsImplMocked : ConnectionUtils {
    override fun isNetworkAvailable() = true
}
