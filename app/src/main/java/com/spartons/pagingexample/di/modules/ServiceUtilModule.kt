package com.spartons.pagingexample.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.spartons.pagingexample.backend.ServiceApi
import com.spartons.pagingexample.di.scope.CustomApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [NetworkModule::class])
class ServiceUtilModule {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    }

    @Provides
    @CustomApplicationScope
    fun getServiceApi(retrofit: Retrofit) = retrofit.create(ServiceApi::class.java)!!

    @Provides
    @CustomApplicationScope
    fun getGson() = GsonBuilder().create()!!

    @Provides
    @CustomApplicationScope
    fun getRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
    }
}