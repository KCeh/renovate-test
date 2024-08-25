package com.infinum.template.backend.data.internal.di.modules

import com.infinum.template.backend.data.api.BackendApi
import com.infinum.template.backend.data.internal.api.BackendApiImpl
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {

    @Provides
    fun backendApi(instance: BackendApiImpl): BackendApi = instance
}
