package com.infinum.template.preferences.data.models

data class AuthData(
    val token: String,
    val client: String,
    val uid: String,
    val autoLogin: Boolean,
)
