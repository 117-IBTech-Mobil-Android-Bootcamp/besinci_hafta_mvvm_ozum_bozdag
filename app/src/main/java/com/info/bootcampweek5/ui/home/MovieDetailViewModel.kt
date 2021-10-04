package com.info.bootcampweek5.ui.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.info.bootcampweek5.network.response.MovieListDetailResponse
import com.info.bootcampweek5.network.response.MovieListResponse
import com.info.bootcampweek5.repository.FilmRepository
import com.info.bootcampweek5.util.API_KEY
import com.info.bootcampweek5.util.MOVIE_ID

class MovieDetailViewModel : ViewModel() {


    val moviesDetailResponse = MediatorLiveData<MovieListDetailResponse>()
    val filmRepository = FilmRepository()

    init {
        filmRepository.getDetails(MOVIE_ID, API_KEY) // init olur olmaz getDetails'i çek


        moviesDetailResponse.addSource(filmRepository.onMoviesDetailFetched) {
            moviesDetailResponse.value = it
        }
    }


}