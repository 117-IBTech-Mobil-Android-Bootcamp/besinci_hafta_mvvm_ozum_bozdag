package com.info.bootcampweek5.ui.filmlist.model

import android.widget.ImageView

data class Movie(
    val title : String,
    val poster_path : String,
    val vote_average : Double,
    val id : Int
)