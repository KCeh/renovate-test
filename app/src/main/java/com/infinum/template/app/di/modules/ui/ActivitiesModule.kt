package com.infinum.template.app.di.modules.ui

import com.infinum.template.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}
