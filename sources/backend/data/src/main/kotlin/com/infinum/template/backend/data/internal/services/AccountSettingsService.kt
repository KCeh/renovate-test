package com.infinum.template.backend.data.internal.services

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockCircular
import co.infinum.retromock.meta.MockResponse
import co.infinum.retromock.meta.MockResponses
import com.infinum.template.backend.data.internal.models.TermsAndConditionsRequest
import retrofit2.http.Body
import retrofit2.http.POST

internal interface AccountSettingsService {

    @Mock
    @MockResponses(
        MockResponse(code = 200),
        MockResponse(code = 400),
    )
    @MockCircular
    @POST("/users/current/terms")
    suspend fun acceptTerms(@Body request: TermsAndConditionsRequest)
}
