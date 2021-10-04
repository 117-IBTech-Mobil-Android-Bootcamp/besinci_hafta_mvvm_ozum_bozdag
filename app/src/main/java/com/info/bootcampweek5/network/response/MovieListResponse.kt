package com.info.bootcampweek5.network.response

import com.info.bootcampweek5.ui.filmlist.model.Movie
import com.google.gson.annotations.SerializedName


data class MovieListResponse(
    val page: Int,
    @SerializedName("results") val movies : List<Movie>

)