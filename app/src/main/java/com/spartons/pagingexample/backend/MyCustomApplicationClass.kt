package com.spartons.pagingexample.backend

import android.app.Application
import com.spartons.pagingexample.di.components.DaggerMyApplicationComponent
import com.spartons.pagingexample.di.components.MyApplicationComponent
import com.spartons.pagingexample.di.modules.ApplicationContextModule

class MyCustomApplicationClass : Application() {

    private lateinit var applicationComponent: MyApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerMyApplicationComponent
                .builder()
                .applicationContextModule(ApplicationContextModule(this))
                .build()
    }

    fun getService() = applicationComponent
}