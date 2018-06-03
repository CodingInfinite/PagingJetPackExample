package com.spartons.pagingexample.di.components

import com.spartons.pagingexample.backend.ServiceApi
import com.spartons.pagingexample.di.modules.MovieSourceModule
import com.spartons.pagingexample.di.modules.PicassoModule
import com.spartons.pagingexample.di.scope.CustomApplicationScope
import com.spartons.pagingexample.models.MovieModel
import com.squareup.picasso.Picasso
import dagger.Component

@CustomApplicationScope
@Component(modules = [MovieSourceModule::class,PicassoModule::class])
interface MyApplicationComponent {

    fun serviceApi(): ServiceApi

    fun movieModel(): MovieModel

    fun picasso() : Picasso
}