package com.spartons.pagingexample.repositories

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.spartons.pagingexample.reponse.MovieResponse

interface MovieRepository {

    fun getMovies(): LiveData<PagedList<MovieResponse.Movie>>

}