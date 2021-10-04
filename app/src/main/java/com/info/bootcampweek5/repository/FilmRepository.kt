package com.info.bootcampweek5.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.info.bootcampweek5.network.BaseCallBack
import com.info.bootcampweek5.network.ServiceConnector
import com.info.bootcampweek5.network.response.MovieListDetailResponse
import com.info.bootcampweek5.network.response.MovieListResponse
import com.info.bootcampweek5.util.API_KEY
import com.info.bootcampweek5.util.MOVIE_ID

class FilmRepository {

    //onMoviesFetched servise istek atıp servis cevabı success olarak döndükten sonra değişiyor
    val onMoviesFetched = MutableLiveData<MovieListResponse>()
    val onMoviesDetailFetched = MutableLiveData<MovieListDetailResponse>()

    fun getAllMovies(apiKey: String)
    {
        ServiceConnector.restInterface.getTopRatedMovies(apiKey).enqueue(object : BaseCallBack<MovieListResponse>(){
            override fun onSuccess(data: MovieListResponse) {
                onMoviesFetched.postValue(data)
            }
        })
    }



    fun getDetails(id : Int, apiKey: String){
        ServiceConnector.restInterface.getMoviesDetail(id, apiKey).enqueue(object : BaseCallBack<MovieListDetailResponse>(){
            override fun onSuccess(data: MovieListDetailResponse) {
                onMoviesDetailFetched.postValue(data)
            }
        })
    }
}