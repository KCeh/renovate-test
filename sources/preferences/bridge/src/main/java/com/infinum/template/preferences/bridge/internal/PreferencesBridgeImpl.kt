package com.infinum.template.preferences.bridge.internal

import com.infinum.template.bridges.LocalBridge
import com.infinum.template.models.AccessData
import com.infinum.template.models.AuthData
import com.infinum.template.preferences.bridge.mapping.authToSource
import com.infinum.template.preferences.bridge.mapping.toDomain
import com.infinum.template.preferences.data.api.PreferencesApi
import javax.inject.Inject

internal class PreferencesBridgeImpl @Inject constructor(
    private val preferencesApi: PreferencesApi,
) : LocalBridge {
    override suspend fun storeAuthData(accessData: AccessData, autoLogin: Boolean) = preferencesApi.setAuthData(
        authToSource(accessData, autoLogin),
    )

    override suspend fun getAuthData(): AuthData = preferencesApi.getAuthData().toDomain()
}
