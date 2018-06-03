package com.spartons.pagingexample.di.modules

import android.app.Application
import android.content.Context
import com.spartons.pagingexample.backend.ServiceApi
import com.spartons.pagingexample.dataSource.MovieDataSourceFactory
import com.spartons.pagingexample.di.qualifiers.ApplicationContextQualifier
import com.spartons.pagingexample.di.scope.CustomApplicationScope
import com.spartons.pagingexample.models.MovieModel
import com.spartons.pagingexample.repositories.MovieRepositoryImp
import dagger.Module
import dagger.Provides

@Module(includes = [ServiceUtilModule::class])
class MovieSourceModule {

    @CustomApplicationScope
    @Provides
    fun provideMovieSourceFactory(serviceApi: ServiceApi) = MovieDataSourceFactory(serviceApi)

    @CustomApplicationScope
    @Provides
    fun provideMovieRepositoryImp(dataSourceFactory: MovieDataSourceFactory) = MovieRepositoryImp(dataSourceFactory)

    @CustomApplicationScope
    @Provides
    fun provideMovieModel(@ApplicationContextQualifier context: Context, movieRepositoryImp: MovieRepositoryImp) = MovieModel(context as Application, movieRepositoryImp)
}
