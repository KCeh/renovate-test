package com.infinum.template.preferences.bridge.di

import com.infinum.template.bridges.LocalBridge

/**
 * Lists all the implementations provided by the preferences bridge module.
 * The implementations provided can be used in other modules that depend on the preferences bridge module.
 * The methods in this interface can be used to obtain the implementations provided.
 */
interface PreferencesBridgeApi {

    fun preferencesBridge(): LocalBridge
}
