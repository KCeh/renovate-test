package com.infinum.template.domain.di

import com.infinum.template.bridges.BackendBridge
import com.infinum.template.bridges.LocalBridge
import com.infinum.template.domain.internal.di.ApiModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        ApiModule::class,
    ],
)
interface DomainComponent : DomainComponentApi {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance localBridge: LocalBridge,
            @BindsInstance backendBridge: BackendBridge,
        ): DomainComponent
    }

    companion object {
        operator fun invoke(
            localBridge: LocalBridge,
            backendBridge: BackendBridge,
        ): DomainComponent = DaggerDomainComponent.factory().create(localBridge, backendBridge)
    }
}
