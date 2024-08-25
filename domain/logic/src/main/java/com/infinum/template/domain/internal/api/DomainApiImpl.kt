package com.infinum.template.domain.internal.api

import com.infinum.template.bridges.BackendBridge
import com.infinum.template.bridges.LocalBridge
import com.infinum.template.domain.api.DomainApi
import com.infinum.template.models.AuthData
import com.infinum.template.parameters.LoginParameters
import javax.inject.Inject

internal class DomainApiImpl @Inject constructor(
    private val localAuth: LocalBridge,
    private val remoteAuth: BackendBridge,
) : DomainApi {
    override suspend fun getStoredAuthorizationData(): AuthData = localAuth.getAuthData()

    override suspend fun login(input: LoginParameters) {
        val credentials = remoteAuth.login(input)
        localAuth.storeAuthData(accessData = credentials.accessData, autoLogin = input.rememberMe)
    }
}
