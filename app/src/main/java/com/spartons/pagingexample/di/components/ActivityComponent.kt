package com.spartons.pagingexample.di.components

import com.spartons.pagingexample.activity.MainActivity
import com.spartons.pagingexample.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [MyApplicationComponent::class])
interface ActivityComponent : MyApplicationComponent {

    fun inject(mainActivity: MainActivity)
}