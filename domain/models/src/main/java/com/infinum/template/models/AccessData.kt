package com.infinum.template.models

data class AccessData(
    val token: String,
    val client: String,
    val uid: String,
) {
    val isValid: Boolean = token.isNotBlank() && client.isNotBlank() && uid.isNotBlank()
}
