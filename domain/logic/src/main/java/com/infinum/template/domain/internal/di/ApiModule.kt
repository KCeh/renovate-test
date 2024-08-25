package com.infinum.template.domain.internal.di

import com.infinum.template.domain.api.DomainApi
import com.infinum.template.domain.internal.api.DomainApiImpl
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {

    @Provides
    fun provideDomainApi(instance: DomainApiImpl): DomainApi = instance
}
