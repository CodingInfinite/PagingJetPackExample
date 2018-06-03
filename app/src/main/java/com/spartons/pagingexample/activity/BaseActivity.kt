package com.spartons.pagingexample.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.spartons.pagingexample.backend.MyCustomApplicationClass
import com.spartons.pagingexample.di.components.ActivityComponent
import com.spartons.pagingexample.di.components.DaggerActivityComponent

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent
                .builder()
                .myApplicationComponent(getApp().getService())
                .build()
    }

    protected fun getComponent() = activityComponent

    private fun getApp() = applicationContext as MyCustomApplicationClass
}