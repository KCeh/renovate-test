package com.infinum.template.app.di.modules

import android.content.Context
import com.infinum.template.app.di.ApplicationScope
import com.infinum.template.coroutines.ApplicationDispatchers
import dagger.Module
import dagger.Provides
import dagger.android.support.DaggerApplication
import kotlinx.coroutines.Dispatchers

@Module
class ApplicationModule {

    @Provides
    @ApplicationScope
    fun applicationContext(application: DaggerApplication): Context = application.applicationContext

    @Provides
    @ApplicationScope
    fun applicationDispatchers(): ApplicationDispatchers = ApplicationDispatchers(
        default = Dispatchers.Default,
        main = Dispatchers.Main,
        io = Dispatchers.IO,
    )
}
