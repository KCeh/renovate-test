package com.infinum.template.preferences.data.di

import com.infinum.template.preferences.data.api.PreferencesApi

/**
 * Lists all the implementations provided by the preferences module.
 * The implementations provided can be used in other modules that depend on the preferences module.
 * The methods in this interface can be used to obtain the implementations provided.
 */
interface PreferencesComponentApi {

    fun preferencesApi(): PreferencesApi
}
