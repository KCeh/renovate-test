package com.infinum.template.preferences.data.internal.api

import com.infinum.template.preferences.data.api.PreferencesApi
import com.infinum.template.preferences.data.internal.Preferences
import com.infinum.template.preferences.data.models.AuthData
import javax.inject.Inject

internal class PreferencesApiImpl @Inject constructor(
    private val preferences: Preferences,
) : PreferencesApi {
    override suspend fun getAuthData(): AuthData = with(preferences) {
        AuthData(
            token = token,
            client = client,
            uid = uid,
            autoLogin = autoLogin,
        )
    }

    override suspend fun setAuthData(input: AuthData) = with(preferences) {
        autoLogin = input.autoLogin
        token = input.token
        client = input.client
        uid = input.uid
    }
}
