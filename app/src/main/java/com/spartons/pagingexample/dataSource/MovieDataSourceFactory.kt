package com.spartons.pagingexample.dataSource

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.spartons.pagingexample.backend.ServiceApi
import com.spartons.pagingexample.reponse.MovieResponse

class MovieDataSourceFactory(private val serviceApi: ServiceApi) : DataSource.Factory<Int, MovieResponse.Movie> {

    private val mutableDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, MovieResponse.Movie> {
        val dataSource = MovieDataSource(serviceApi)
        mutableDataSource.postValue(dataSource)
        return dataSource
    }
}
