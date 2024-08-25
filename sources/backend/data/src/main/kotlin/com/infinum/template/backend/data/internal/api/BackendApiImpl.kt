package com.infinum.template.backend.data.internal.api

import com.infinum.template.backend.data.api.BackendApi
import com.infinum.template.backend.data.internal.models.LoginRequest
import com.infinum.template.backend.data.internal.models.TermsAndConditionsRequest
import com.infinum.template.backend.data.internal.services.AccountSettingsService
import com.infinum.template.backend.data.internal.services.LoginService
import com.infinum.template.backend.data.models.AuthorizationResponse
import com.infinum.template.backend.data.models.LoginResponse
import javax.inject.Inject
import retrofit2.HttpException
import retrofit2.Response

internal class BackendApiImpl @Inject constructor(
    private val loginService: LoginService,
    private val accountSettingsService: AccountSettingsService,
) : BackendApi {
    override suspend fun login(email: String, password: String): AuthorizationResponse {
        val response = doLogin(email = email, password = password)

        setupTermsAndConditions(email)

        return response
    }

    private suspend fun doLogin(email: String, password: String): AuthorizationResponse {
        val response = loginService.login(LoginRequest(email, password))
        if (response.isSuccessful) {
            return response.toAuthorizationResponse()
        } else {
            // In regular scenario Retrofit throws this exception automatically, but not when return parameter is Response
            // and we need Response to parse the headers.
            throw HttpException(response)
        }
    }

    /**
     * This is here to extract all response information as close to .
     * Access token, client and uid are not received in the response body, but in the headers.
     * If there were no header information in the response, we would just propagate a regular model received from the response body.
     */
    private fun Response<LoginResponse>.toAuthorizationResponse() = AuthorizationResponse(
        accessToken = headers()["access-token"].orEmpty(),
        client = headers()["client"].orEmpty(),
        uid = headers()["uid"].orEmpty(),
        response = requireNotNull(body()),
    )

    private suspend fun setupTermsAndConditions(email: String) {
        // let's say the requirement is to automatically accept all terms for our users,
        // but set to rejected for all other users on each login (for whatever reason)
        if (email.endsWith("@infinum.com")) {
            accountSettingsService.acceptTerms(TermsAndConditionsRequest(hasAccepted = true))
        } else {
            accountSettingsService.acceptTerms(TermsAndConditionsRequest(hasAccepted = false))
        }
    }
}
