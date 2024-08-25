package com.infinum.template.backend.data.di

import com.infinum.template.backend.data.api.BackendApi

/**
 * Lists all the implementations provided by the backend module.
 * The implementations provided can be used in other modules that depend on the backend module.
 * The methods in this interface can be used to obtain the implementations provided.
 */
interface BackendComponentApi {
    fun backend(): BackendApi
}
