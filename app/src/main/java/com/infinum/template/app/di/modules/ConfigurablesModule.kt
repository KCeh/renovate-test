package com.infinum.template.app.di.modules

import com.infinum.template.app.configurables.Configurable
import com.infinum.template.app.configurables.TimberConfigurable
import com.infinum.template.app.di.ApplicationScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
interface ConfigurablesModule {

    @Binds
    @ApplicationScope
    @IntoSet
    fun timberConfigurable(configurable: TimberConfigurable): Configurable
}
