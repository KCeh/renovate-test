package com.infinum.template.bridges

import com.infinum.template.models.AccessData
import com.infinum.template.models.AuthData

interface LocalBridge {

    suspend fun storeAuthData(accessData: AccessData, autoLogin: Boolean)

    suspend fun getAuthData(): AuthData
}
