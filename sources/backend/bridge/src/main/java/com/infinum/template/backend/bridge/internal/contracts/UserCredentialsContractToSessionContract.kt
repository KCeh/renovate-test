package com.infinum.template.backend.bridge.internal.contracts

import com.infinum.template.backend.bridge.contract.UserCredentialsContract
import com.infinum.template.backend.data.contract.SessionContract

internal class UserCredentialsContractToSessionContract(
    private val userCredentialsContract: UserCredentialsContract,
) : SessionContract {
    override suspend fun getLocalAuthToken(): String = userCredentialsContract.getLocalAuthToken()

    override suspend fun getLocalAuthClient(): String = userCredentialsContract.getLocalAuthClient()

    override suspend fun getLocalAuthUid(): String = userCredentialsContract.getLocalAuthUid()
}
