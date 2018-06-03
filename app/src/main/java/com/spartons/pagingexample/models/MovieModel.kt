package com.spartons.pagingexample.models

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.spartons.pagingexample.repositories.MovieRepositoryImp
import javax.inject.Inject

class MovieModel @Inject constructor(app: Application,
                                     private val movieRepositoryImp: MovieRepositoryImp) : AndroidViewModel(app) {

    fun getMoviesObserver() = movieRepositoryImp.getMovies()
}
