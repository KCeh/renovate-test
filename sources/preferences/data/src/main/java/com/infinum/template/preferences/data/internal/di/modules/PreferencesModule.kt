package com.infinum.template.preferences.data.internal.di.modules

import com.infinum.template.preferences.data.internal.Preferences
import com.infinum.template.preferences.data.internal.PreferencesImpl
import dagger.Binds
import dagger.Module

@Module
internal interface PreferencesModule {

    @Binds
    fun preferences(preferences: PreferencesImpl): Preferences
}
