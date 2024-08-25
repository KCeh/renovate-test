package com.infinum.template.preferences.bridge.di

import com.infinum.template.bridges.LocalBridge
import com.infinum.template.preferences.bridge.internal.PreferencesBridgeImpl
import dagger.Binds
import dagger.Module

@Module
internal interface PreferencesModule {

    @Binds
    fun localBridge(instance: PreferencesBridgeImpl): LocalBridge
}
