package com.infinum.template.backend.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName(value = "id") val id: String,
    @SerialName(value = "email") val email: String,
    @SerialName(value = "image_url") val imageUrl: String,
)
