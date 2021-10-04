
package com.info.bootcampweek5.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.info.bootcampweek5.R
import com.info.bootcampweek5.base.BaseFragment
import com.info.bootcampweek5.databinding.FragmentHomeBinding
import com.info.bootcampweek5.ui.filmlist.adapter.MovieListAdapter
import com.info.bootcampweek5.ui.filmlist.model.FilmListViewStateModel
import com.info.bootcampweek5.ui.home.detailModel.Detail
import com.info.bootcampweek5.ui.home.detailModel.FilmListDetailViewStateModel
import com.info.bootcampweek5.util.API_KEY
import com.info.bootcampweek5.util.MOVIE_ID
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment<MovieDetailViewModel, FragmentHomeBinding >() {

    override var viewModel: MovieDetailViewModel ?= null

    override fun getLayoutID(): Int = R.layout.fragment_home

    override fun prepareView() {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {}

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
    }
    override fun observeLiveData() {}

    override fun shouldCheckInternetConnection() = false


}
