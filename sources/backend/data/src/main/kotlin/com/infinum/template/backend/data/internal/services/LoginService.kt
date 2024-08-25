package com.infinum.template.backend.data.internal.services

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockCircular
import co.infinum.retromock.meta.MockResponse
import co.infinum.retromock.meta.MockResponses
import com.infinum.template.backend.data.internal.models.LoginRequest
import com.infinum.template.backend.data.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

internal interface LoginService {

    @Suppress("TrimMultilineRawString")
    @Mock
    @MockResponses(
        MockResponse(
            body = """
                {
                  "user": {
                    "id": "mock_id",
                    "email": "mock.email@infinum.com",
                    "image_url": "infinum.com/mock_image.png"
                  }
                }
            """,
        ),
        MockResponse(
            code = 400,
        ),
    )
    @MockCircular
    @POST("/users/sign_in")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}
