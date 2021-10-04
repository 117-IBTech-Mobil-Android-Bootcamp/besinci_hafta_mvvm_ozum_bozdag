package com.info.bootcampweek5.ui.home.detailModel

import com.info.bootcampweek5.R
import com.info.bootcampweek5.network.response.MovieListDetailResponse
import com.info.bootcampweek5.network.response.MovieListResponse

data class FilmListDetailViewStateModel(val movieDetailsResponse: MovieListDetailResponse){
    fun getTitle() : String = movieDetailsResponse.title
}
