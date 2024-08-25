package com.infinum.template.app.contracts

import com.infinum.template.backend.bridge.contract.UserCredentialsContract
import com.infinum.template.domain.api.DomainApi
import javax.inject.Inject

internal class AuthUserCredentialsContract @Inject constructor(
    private val getAuthData: () -> DomainApi,
) : UserCredentialsContract {
    override suspend fun getLocalAuthToken(): String = getAuthData().getStoredAuthorizationData().accessData.token
    override suspend fun getLocalAuthClient(): String = getAuthData().getStoredAuthorizationData().accessData.client
    override suspend fun getLocalAuthUid(): String = getAuthData().getStoredAuthorizationData().accessData.uid
}
