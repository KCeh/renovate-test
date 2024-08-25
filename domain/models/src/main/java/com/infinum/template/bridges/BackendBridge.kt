package com.infinum.template.bridges

import com.infinum.template.models.AccessUser
import com.infinum.template.parameters.LoginParameters

interface BackendBridge {
    suspend fun login(parameters: LoginParameters): AccessUser
}
