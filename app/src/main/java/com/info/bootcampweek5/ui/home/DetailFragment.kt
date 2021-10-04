package com.info.bootcampweek5.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.info.bootcampweek5.R
import com.info.bootcampweek5.base.BaseFragment
import com.info.bootcampweek5.databinding.FragmentDetailBinding
import com.info.bootcampweek5.databinding.FragmentHomeBinding
import com.info.bootcampweek5.ui.home.detailModel.FilmListDetailViewStateModel
import com.info.bootcampweek5.util.API_KEY
import com.info.bootcampweek5.util.MOVIE_ID
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_home.*
//import kotlinx.android.synthetic.main.fragment_home.textView


class DetailFragment : BaseFragment<MovieDetailViewModel, FragmentDetailBinding>() {
    var clickedItemId: Int? = null
    var titleOfMovie : String? = null
    var voteOfMovie : Double? = null
    override var viewModel: MovieDetailViewModel ?= null



    override fun getLayoutID(): Int = R.layout.fragment_home

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_detail, container, false)
        clickedItemId = arguments?.getInt("clickedItemID")
        titleOfMovie = arguments?.getString("movietitle")
        voteOfMovie = arguments?.getDouble("voteOfMovie")
        return root
    }
    override fun prepareView() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView.text = clickedItemId.toString()
        movieTitle.text = titleOfMovie
        voteText.text = voteOfMovie.toString()
    }


    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)

    }


    override fun observeLiveData() {
        viewModel?.moviesDetailResponse?.observe(this, {
            dataBinding.moviesDetailResponse= FilmListDetailViewStateModel(it)
            dataBinding.executePendingBindings()
        })
    }



}