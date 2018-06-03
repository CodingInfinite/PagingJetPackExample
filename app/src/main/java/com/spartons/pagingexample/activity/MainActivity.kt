package com.spartons.pagingexample.activity

import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.spartons.pagingexample.R
import com.spartons.pagingexample.adapter.MovieAdapter
import com.spartons.pagingexample.models.MovieModel
import com.spartons.pagingexample.reponse.MovieResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var movieModel: MovieModel
    @Inject
    lateinit var picasso: Picasso
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getComponent().inject(this)
        setAdapter()
        movieModel.getMoviesObserver()
                .observe(this, Observer<PagedList<MovieResponse.Movie>> {
                    movieAdapter.submitList(it)
                })
    }

    private fun setAdapter() {
        movieRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        movieRecyclerView.setHasFixedSize(true)
        movieAdapter = MovieAdapter(this, picasso)
        movieRecyclerView.adapter = movieAdapter
    }

    override fun onStop() {
        super.onStop()
        movieModel
                .getMoviesObserver()
                .removeObservers(this)
    }
}
