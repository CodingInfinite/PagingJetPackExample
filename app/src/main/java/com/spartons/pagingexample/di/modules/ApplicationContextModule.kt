package com.spartons.pagingexample.di.modules

import android.content.Context
import com.spartons.pagingexample.di.qualifiers.ApplicationContextQualifier
import com.spartons.pagingexample.di.scope.CustomApplicationScope
import dagger.Module
import dagger.Provides

@Module
class ApplicationContextModule(private var context: Context) {

    @Provides
    @CustomApplicationScope
    @ApplicationContextQualifier
    fun getContext() = context
}