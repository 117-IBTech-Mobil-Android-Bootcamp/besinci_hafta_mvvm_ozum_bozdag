package com.info.bootcampweek5.ui.filmlist

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.info.bootcampweek5.network.response.MovieListResponse
import com.info.bootcampweek5.repository.FilmRepository
import com.info.bootcampweek5.util.API_KEY

class MovieListViewModel : ViewModel() {

    val moviesResponse = MediatorLiveData<MovieListResponse>()
    val filmRepository = FilmRepository()

    init {
        filmRepository.getAllMovies(API_KEY) // init olur olmaz getAllMovies'i çek

        moviesResponse.addSource(filmRepository.onMoviesFetched) {
            moviesResponse.value = it //onMoviesFetched her değiştiğinde valuesuna servisten dönen değeri ata
        }
    }
}