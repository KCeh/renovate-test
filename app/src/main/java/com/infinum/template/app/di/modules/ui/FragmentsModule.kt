package com.infinum.template.app.di.modules.ui

import com.infinum.template.app.di.modules.ui.login.LoginModule
import com.infinum.template.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    fun loginFragment(): LoginFragment
}
