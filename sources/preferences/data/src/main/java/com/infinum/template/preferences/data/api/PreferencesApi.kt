package com.infinum.template.preferences.data.api

import com.infinum.template.preferences.data.models.AuthData

interface PreferencesApi {

    suspend fun getAuthData(): AuthData

    suspend fun setAuthData(input: AuthData)
}
