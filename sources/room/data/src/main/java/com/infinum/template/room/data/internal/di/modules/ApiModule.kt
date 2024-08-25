package com.infinum.template.room.data.internal.di.modules

import com.infinum.template.room.data.api.DatabaseApi
import com.infinum.template.room.data.internal.api.DatabaseApiImpl
import dagger.Module
import dagger.Provides

@Module
internal class ApiModule {

    @Provides
    fun databaseApi(instance: DatabaseApiImpl): DatabaseApi = instance
}
