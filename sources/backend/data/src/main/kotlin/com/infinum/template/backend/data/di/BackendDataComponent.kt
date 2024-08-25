package com.infinum.template.backend.data.di

import com.infinum.template.backend.data.contract.SessionContract
import com.infinum.template.backend.data.internal.di.modules.ApiModule
import com.infinum.template.backend.data.internal.di.modules.NetworkingModule
import com.infinum.template.common.logging.Logger
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        NetworkingModule::class,
        ApiModule::class,
    ],
)
interface BackendDataComponent : BackendComponentApi {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance logger: Logger,
            @BindsInstance sessionContract: SessionContract,
        ): BackendDataComponent
    }

    companion object {
        operator fun invoke(
            sessionContract: SessionContract,
            logger: Logger,
        ): BackendDataComponent = DaggerBackendDataComponent.factory().create(logger, sessionContract)
    }
}
