package com.infinum.template.backend.data.contract

interface SessionContract {
    suspend fun getLocalAuthToken(): String
    suspend fun getLocalAuthClient(): String
    suspend fun getLocalAuthUid(): String
}
