package com.infinum.template.app

import com.infinum.template.app.configurables.Configurable
import com.infinum.template.app.contracts.AuthUserCredentialsContract
import com.infinum.template.app.di.DaggerAppComponent
import com.infinum.template.app.logging.JdkTimberAdapter
import com.infinum.template.backend.bridge.di.BackendBridgeComponent
import com.infinum.template.domain.api.DomainApi
import com.infinum.template.domain.di.DomainComponent
import com.infinum.template.preferences.bridge.di.PreferencesBridgeComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class TemplateApp : DaggerApplication() {

    @Inject
    lateinit var configurables: Set<@JvmSuppressWildcards Configurable>

    @Inject
    lateinit var domainApi: DomainApi

    override fun applicationInjector(): AndroidInjector<TemplateApp> {
        val backendBridgeComponent = BackendBridgeComponent(
            userCredentialsContract = AuthUserCredentialsContract { domainApi },
            // provide logger to a module as dependency, or use JdkTimber in the module without dependency injection
            logger = JdkTimberAdapter(),
        )
        val preferencesBridgeComponent = PreferencesBridgeComponent(
            context = this,
        )
        val domainComponent = DomainComponent(
            localBridge = preferencesBridgeComponent.preferencesBridge(),
            backendBridge = backendBridgeComponent.backendBridge(),
        )
        return DaggerAppComponent.factory().create(
            domainComponent = domainComponent,
            application = this,
        )
    }

    override fun onCreate() {
        super.onCreate()
        configurables.forEach { it.configure() }
    }
}
