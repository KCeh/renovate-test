package com.infinum.template.backend.bridge.di

import com.infinum.template.bridges.BackendBridge

/**
 * Lists all the implementations provided by the backend bridge module.
 * The implementations provided can be used in other modules that depend on the backend bridge module.
 * The methods in this interface can be used to obtain the implementations provided.
 */
interface BackendBridgeApi {
    fun backendBridge(): BackendBridge
}
