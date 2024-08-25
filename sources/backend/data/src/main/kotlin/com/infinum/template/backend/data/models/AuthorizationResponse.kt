package com.infinum.template.backend.data.models

/**
 * Holds full information of the login response.
 * Access token, client and uid are not received in the response body, but in the headers
 */
data class AuthorizationResponse(
    val accessToken: String,
    val client: String,
    val uid: String,
    val response: LoginResponse,
)
