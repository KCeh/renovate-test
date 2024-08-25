package com.infinum.template.backend.bridge.contract

interface UserCredentialsContract {
    /**
     * App chooses which module contains implementation details for local token storage
     */
    suspend fun getLocalAuthToken(): String
    suspend fun getLocalAuthClient(): String
    suspend fun getLocalAuthUid(): String
}
