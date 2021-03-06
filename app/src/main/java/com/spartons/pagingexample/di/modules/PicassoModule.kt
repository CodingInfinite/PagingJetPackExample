package com.spartons.pagingexample.di.modules

import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import com.spartons.pagingexample.di.modules.NetworkModule
import com.spartons.pagingexample.di.qualifiers.ApplicationContextQualifier
import com.spartons.pagingexample.di.scope.CustomApplicationScope
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module(includes = [NetworkModule::class])
class PicassoModule {

    @Provides
    @CustomApplicationScope
    fun getOkHttp3Downloader(okHttpClient: OkHttpClient) = OkHttp3Downloader(okHttpClient)

    @Provides
    @CustomApplicationScope
    fun getPicasso(@ApplicationContextQualifier context: Context, okHttpDownloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context)
                .downloader(okHttpDownloader)
                .build()
    }
}
