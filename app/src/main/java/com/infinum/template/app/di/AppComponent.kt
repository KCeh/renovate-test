package com.infinum.template.app.di

import android.app.Application
import com.infinum.template.app.TemplateApp
import com.infinum.template.app.di.modules.ApplicationModule
import com.infinum.template.app.di.modules.ConfigurablesModule
import com.infinum.template.app.di.modules.ui.ActivitiesModule
import com.infinum.template.app.di.modules.ui.FragmentsModule
import com.infinum.template.domain.di.DomainComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    dependencies = [
        DomainComponent::class,
    ],
    modules = [
        ConfigurablesModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivitiesModule::class,
        FragmentsModule::class,
    ],
)
@ApplicationScope
interface AppComponent : AndroidInjector<TemplateApp> {

    @Component.Factory
    interface Factory {
        fun create(
            domainComponent: DomainComponent,
            @BindsInstance application: Application,
        ): AppComponent
    }
}
