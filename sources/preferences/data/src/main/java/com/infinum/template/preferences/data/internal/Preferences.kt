package com.infinum.template.preferences.data.internal

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

internal interface Preferences {
    var token: String
    var client: String
    var uid: String
    var autoLogin: Boolean
}

internal class PreferencesImpl @Inject constructor(
    private val context: Context,
) : Preferences {

    /**
     * https://kotlinlang.org/docs/reference/delegated-properties.html
     *
     * Lazy is awesome.
     */
    private val prefs by lazy {
        context.getSharedPreferences(
            SHOWS_SHARED_PREFS,
            Context.MODE_PRIVATE,
        )
    }

    override var token: String
        get() = prefs.getString(SHARED_PREFS_TOKEN, "").orEmpty()
        set(value) {
            prefs.edit { putString(SHARED_PREFS_TOKEN, value) }
        }

    override var client: String
        get() = prefs.getString(SHARED_PREFS_CLIENT, "").orEmpty()
        set(value) {
            prefs.edit { putString(SHARED_PREFS_CLIENT, value) }
        }

    override var uid: String
        get() = prefs.getString(SHARED_PREFS_UID, "").orEmpty()
        set(value) {
            prefs.edit { putString(SHARED_PREFS_UID, value) }
        }

    override var autoLogin: Boolean
        get() = prefs.getBoolean(SHARED_PREFS_AUTOLOGIN, false)
        set(value) {
            prefs.edit { putBoolean(SHARED_PREFS_AUTOLOGIN, value) }
        }

    /**
     * By using extension functions you can never forget to call apply()
     */
    private fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> SharedPreferences.Editor) {
        edit().action().apply()
    }

    companion object {
        private const val SHOWS_SHARED_PREFS = "Shows_sharedPrefs"
        private const val SHARED_PREFS_TOKEN = "token"
        private const val SHARED_PREFS_CLIENT = "client"
        private const val SHARED_PREFS_UID = "uid"
        private const val SHARED_PREFS_AUTOLOGIN = "autologin"
    }
}
