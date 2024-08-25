package com.infinum.template.backend.bridge.internal

import com.infinum.template.backend.bridge.mappers.bridge
import com.infinum.template.backend.bridge.mappers.toDomain
import com.infinum.template.backend.data.api.BackendApi
import com.infinum.template.bridges.BackendBridge
import com.infinum.template.common.throwIfUnrecoverable
import com.infinum.template.exceptions.LoginUnsuccessful
import com.infinum.template.models.AccessUser
import com.infinum.template.parameters.LoginParameters
import javax.inject.Inject

internal class BackendBridgeImpl @Inject constructor(
    private val backendApi: BackendApi,
) : BackendBridge {
    override suspend fun login(parameters: LoginParameters): AccessUser = try {
        // execute runs the given block and wraps exceptions inside to domain specific exceptions
        bridge { backendApi.login(email = parameters.email, password = parameters.password) }.toDomain()
    } catch (error: Throwable) {
        // this is usually not needed, but if we want to throw a specific exception for a particular action, do it like this
        error.throwIfUnrecoverable()
        throw LoginUnsuccessful(error)
    }
}
