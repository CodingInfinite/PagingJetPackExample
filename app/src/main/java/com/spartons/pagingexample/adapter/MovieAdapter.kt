package com.spartons.pagingexample.adapter

import android.arch.paging.PagedListAdapter
import android.content.Context
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.spartons.pagingexample.R
import com.spartons.pagingexample.reponse.MovieResponse
import com.spartons.pagingexample.viewHolder.MovieViewHolder
import com.squareup.picasso.Picasso

class MovieAdapter(context: Context, private val picasso: Picasso) : PagedListAdapter<MovieResponse.Movie, MovieViewHolder>(object : DiffUtil.ItemCallback<MovieResponse.Movie>() {
    override fun areItemsTheSame(oldItem: MovieResponse.Movie, newItem: MovieResponse.Movie) = oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: MovieResponse.Movie, newItem: MovieResponse.Movie) = oldItem.title == newItem.title

}) {

    companion object {
        const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185"
    }

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(layoutInflater.inflate(R.layout.movie_single_view, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            picasso.load(IMAGE_BASE_URL.plus(movie.posterPath)).into(holder.moviePosterImageView)
            holder.movieRatingTextView.text = movie.voteAverage.toString()
            holder.movieTitleTextView.text = movie.title
        }
    }
}