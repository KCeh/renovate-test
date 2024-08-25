package com.infinum.template.preferences.data.di

import android.content.Context
import com.infinum.template.preferences.data.internal.di.modules.ApiModule
import com.infinum.template.preferences.data.internal.di.modules.PreferencesModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        PreferencesModule::class,
        ApiModule::class,
    ],
)
interface PreferencesDataComponent : PreferencesComponentApi {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
        ): PreferencesDataComponent
    }

    companion object {
        operator fun invoke(context: Context): PreferencesDataComponent =
            DaggerPreferencesDataComponent.factory().create(context)
    }
}
