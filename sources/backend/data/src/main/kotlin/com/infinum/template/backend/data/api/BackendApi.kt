package com.infinum.template.backend.data.api

import com.infinum.template.backend.data.models.AuthorizationResponse

interface BackendApi {
    suspend fun login(email: String, password: String): AuthorizationResponse
}
