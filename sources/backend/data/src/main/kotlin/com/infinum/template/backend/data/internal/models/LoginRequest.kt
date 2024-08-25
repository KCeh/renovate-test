package com.infinum.template.backend.data.internal.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class LoginRequest(
    @SerialName(value = "email") val email: String,
    @SerialName(value = "password") val password: String,
)
