package com.info.bootcampweek5.ui.filmlist.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.info.bootcampweek5.OnItemClickListener
import com.info.bootcampweek5.R
import com.info.bootcampweek5.databinding.RowFilmBinding
import com.info.bootcampweek5.ui.filmlist.model.Movie


class MovieListAdapter(private val movieList: List<Movie>, private val listener : OnItemClickListener) : RecyclerView.Adapter<MovieListAdapter.FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
                DataBindingUtil.inflate(//Databinding üzerinden inflate edioruz
                        LayoutInflater.from(parent.context),
                        R.layout.row_film, //Hangi layoutu bind edeceğimizi verdik
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val movie = this.movieList[position]
        holder.populate(movie)

    }

    override fun getItemCount() = this.movieList.size

    inner class FilmViewHolder(private val binding: RowFilmBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun populate(movie: Movie) {
            binding.movie = movie
            Glide.with(binding.root)
                    .load("https://image.tmdb.org/t/p/w500/"+movie.poster_path)
                    .into(binding.imgRecycler)
            binding.executePendingBindings()
        }

        init {
            itemView.setOnClickListener (this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val data = binding.movie!!.id
            val movieTitle = binding.movie!!.title
            val movieVote = binding.movie!!.vote_average
            if (position != RecyclerView.NO_POSITION) {
                listener.passData(data, movieTitle, movieVote)
            }
        }
    }

}