package com.infinum.template.backend.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName(value = "user") val user: UserResponse,
)
