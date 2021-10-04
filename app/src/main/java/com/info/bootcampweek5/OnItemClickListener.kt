package com.info.bootcampweek5

interface OnItemClickListener {

    fun passData(clickedId : Int, titleOfMovie : String, voteOfMovie : Double)
}