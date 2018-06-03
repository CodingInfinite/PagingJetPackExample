package com.spartons.pagingexample.repositories

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.arch.paging.PagedList.Config.Builder
import android.support.annotation.MainThread
import com.spartons.pagingexample.dataSource.MovieDataSourceFactory
import com.spartons.pagingexample.reponse.MovieResponse
import java.util.concurrent.Executors

class MovieRepositoryImp(private val movieDataSourceFactory: MovieDataSourceFactory) : MovieRepository {

    companion object {
        const val PAGE_SIZE = 15
    }

    @MainThread
    override fun getMovies(): LiveData<PagedList<MovieResponse.Movie>> {
        val config = Builder()
                .setInitialLoadSizeHint(PAGE_SIZE)
                .setPageSize(PAGE_SIZE)
                .build()
        return LivePagedListBuilder(movieDataSourceFactory, config)
                .setInitialLoadKey(1)
                .setBackgroundThreadExecutor(Executors.newFixedThreadPool(3))
                .build()
    }
}
