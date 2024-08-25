package com.infinum.template.domain.api

import com.infinum.template.models.AuthData
import com.infinum.template.parameters.LoginParameters

/**
 * As soon as possible look to split this interface into multiple interfaces,
 * usually by feature or by use case.
 * It isn't sustainable that one interface contains all the domain logic.
 * There will definitely be a lot of the methods from each bridge will be used by the implementations.
 *
 * In that case, create an interface that will contain all the methods for one purpose, for example, AuthorizationDomainApi could be created
 * for authorization purposes:
 * ```
 * interface AuthorizationDomainApi {
 *     suspend fun getStoredAuthorizationData(): AuthData
 *     suspend fun login(input: LoginParameters)
 * }
 * ```
 *
 * If that interface will grow in the future, it can be split into multiple interfaces,
 * for example LoginDomainApi and RegistrationDomainApi.
 */
interface DomainApi {
    suspend fun getStoredAuthorizationData(): AuthData
    suspend fun login(input: LoginParameters)
}
