package com.infinum.template.backend.bridge.di

import com.infinum.template.backend.bridge.contract.UserCredentialsContract
import com.infinum.template.backend.bridge.internal.contracts.UserCredentialsContractToSessionContract
import com.infinum.template.backend.data.di.BackendDataComponent
import com.infinum.template.common.logging.Logger
import dagger.Component

@Component(
    dependencies = [
        BackendDataComponent::class,
    ],
    modules = [
        BridgeBackendModule::class,
    ],
)
interface BackendBridgeComponent : BackendBridgeApi {

    @Component.Factory
    interface Factory {
        fun create(backendDataComponent: BackendDataComponent): BackendBridgeComponent
    }

    companion object {
        operator fun invoke(
            userCredentialsContract: UserCredentialsContract,
            logger: Logger,
        ): BackendBridgeComponent = DaggerBackendBridgeComponent.factory().create(
            backendDataComponent = BackendDataComponent(
                sessionContract = UserCredentialsContractToSessionContract(userCredentialsContract),
                logger = logger,
            ),
        )
    }
}
