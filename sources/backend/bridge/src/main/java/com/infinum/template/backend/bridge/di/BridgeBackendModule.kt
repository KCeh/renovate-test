package com.infinum.template.backend.bridge.di

import com.infinum.template.backend.bridge.internal.BackendBridgeImpl
import com.infinum.template.bridges.BackendBridge
import dagger.Binds
import dagger.Module

@Module
internal interface BridgeBackendModule {

    @Binds
    fun backend(bridge: BackendBridgeImpl): BackendBridge
}
