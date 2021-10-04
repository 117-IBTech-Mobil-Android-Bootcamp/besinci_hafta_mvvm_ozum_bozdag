package com.info.bootcampweek5.ui.filmlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.info.bootcampweek5.OnItemClickListener
import com.info.bootcampweek5.R
import com.info.bootcampweek5.base.BaseFragment
import com.info.bootcampweek5.databinding.FragmentMovieListBinding
import com.info.bootcampweek5.ui.filmlist.adapter.MovieListAdapter
import com.info.bootcampweek5.ui.filmlist.model.FilmListViewStateModel
import com.info.bootcampweek5.ui.home.DetailFragment
import com.info.bootcampweek5.ui.home.HomeFragment

class MovieListFragment: BaseFragment<MovieListViewModel, FragmentMovieListBinding>(), OnItemClickListener {
    override var viewModel: MovieListViewModel? = null
    override fun getLayoutID() = R.layout.fragment_movie_list


    override fun prepareView() {
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
    }

    override fun observeLiveData() {
        viewModel?.moviesResponse?.observe(this, {
            dataBinding.movieListResponse= FilmListViewStateModel(it)
            dataBinding.executePendingBindings()

            dataBinding.recyclerView.adapter = MovieListAdapter(it.movies, this@MovieListFragment)
        })
    }


    override fun passData(clickedId: Int, titleOfMovie : String, voteOfMovie : Double) {
        val bundle = Bundle()
        bundle.putInt("clickedItemID", clickedId)
        bundle.putString("movietitle", titleOfMovie)
        bundle.putDouble("voteOfMovie", voteOfMovie)

        val frag2 = DetailFragment()
        frag2.arguments = bundle
        findNavController().navigate(R.id.action_filmListFragment_to_detailFragment, bundle)

    }
}