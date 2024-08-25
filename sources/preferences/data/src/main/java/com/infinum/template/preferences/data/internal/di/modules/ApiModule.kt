package com.infinum.template.preferences.data.internal.di.modules

import com.infinum.template.preferences.data.api.PreferencesApi
import com.infinum.template.preferences.data.internal.api.PreferencesApiImpl
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {

    @Provides
    fun preferencesApi(instance: PreferencesApiImpl): PreferencesApi = instance
}
