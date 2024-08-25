package com.infinum.template.parameters

data class LoginParameters(
    val email: String,
    val password: String,
    val rememberMe: Boolean,
)
