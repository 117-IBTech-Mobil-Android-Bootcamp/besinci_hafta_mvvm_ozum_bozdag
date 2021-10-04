package com.info.bootcampweek5.network

import com.info.bootcampweek5.network.response.MovieListDetailResponse
import com.info.bootcampweek5.network.response.MovieListResponse
import retrofit2.Call
import retrofit2.http.*

interface MovieAPI {


    @GET("popular")
    fun getTopRatedMovies(@Query("api_key") apikey : String) : Call<MovieListResponse>

    @GET("{movie_id}")
    fun getMoviesDetail(@Path("movie_id") movie_id : Int, @Query("api_key") apikey:String) : Call<MovieListDetailResponse >

}