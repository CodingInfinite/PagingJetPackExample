package com.spartons.pagingexample.dataSource

import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.spartons.pagingexample.backend.ServiceApi
import com.spartons.pagingexample.reponse.MovieResponse
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call

class MovieDataSource(private val serviceApi: ServiceApi) : PageKeyedDataSource<Int, MovieResponse.Movie>() {

    companion object {
        const val MOVIE_API_KEY = "e5c704134****************8b720e80c7"   // Replace with your API key. Get Api key from themoviedb.org
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MovieResponse.Movie>) {
        val movieCallback: Call<MovieResponse> = serviceApi.getPopular(MOVIE_API_KEY, 1)
        Completable.fromRunnable {
            val response = movieCallback.execute()
            if (response != null && response.isSuccessful && response.body() != null)
                callback.onResult(response.body()!!.movies, 1, 2)
        }.subscribeOn(Schedulers.io())
                .subscribe({ },
                        { it.printStackTrace() })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MovieResponse.Movie>) {
        val movieCallback = serviceApi.getPopular(MOVIE_API_KEY, params.key)
        Completable.fromRunnable {
            val response = movieCallback.execute()
            if (response != null && response.isSuccessful && response.body() != null)
                callback.onResult(response.body()!!.movies, params.key + 1)
        }.subscribeOn(Schedulers.io())
                .subscribe({
                    Log.e("Call Response", "Paged Call Complete")
                }, { it.printStackTrace() })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MovieResponse.Movie>) {
//        val movieCallback = serviceApi.getPopular(API_KEY, page =)
    }
}