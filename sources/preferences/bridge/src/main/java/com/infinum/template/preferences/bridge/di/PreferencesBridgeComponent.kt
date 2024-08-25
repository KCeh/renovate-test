package com.infinum.template.preferences.bridge.di

import android.content.Context
import com.infinum.template.preferences.data.di.PreferencesDataComponent
import dagger.Component

@Component(
    dependencies = [
        PreferencesDataComponent::class,
    ],
    modules = [
        PreferencesModule::class,
    ],
)
interface PreferencesBridgeComponent : PreferencesBridgeApi {

    @Component.Factory
    interface Factory {
        fun create(
            dataSharedPrefsComponent: PreferencesDataComponent,
        ): PreferencesBridgeComponent
    }

    companion object {
        operator fun invoke(context: Context): PreferencesBridgeComponent = DaggerPreferencesBridgeComponent.factory().create(
            PreferencesDataComponent(context),
        )
    }
}
