package com.infinum.template.domain.di

import com.infinum.template.domain.api.DomainApi

/**
 * Lists all the implementations provided by the domain module.
 * The implementations provided can be used in other modules that depend on the domain module.
 * The methods in this interface can be used to obtain the implementations provided.
 */
interface DomainComponentApi {
    fun domainApi(): DomainApi
}
