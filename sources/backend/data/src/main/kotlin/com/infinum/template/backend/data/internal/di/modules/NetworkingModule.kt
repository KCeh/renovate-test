package com.infinum.template.backend.data.internal.di.modules

import co.infinum.retromock.Retromock
import com.infinum.template.backend.data.contract.SessionContract
import com.infinum.template.backend.data.internal.converters.ParsingConverter
import com.infinum.template.backend.data.internal.services.AccountSettingsService
import com.infinum.template.backend.data.internal.services.LoginService
import com.infinum.template.common.logging.Logger
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
internal class NetworkingModule {

    /**
     * [Retromock] is used for mocking ApiService in this template.
     */
    @Provides
    fun apiService(retromock: Retromock) = retromock.create(LoginService::class.java)

    @Provides
    fun accountSettingsService(retromock: Retromock): AccountSettingsService = retromock.create(AccountSettingsService::class.java)

    @Provides
    fun retrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(
            ParsingConverter.Factory(
                Json.asConverterFactory(
                    MEDIA_TYPE_JSON.toMediaType(),
                ),
            ),
        )
        .build()

    @Provides
    fun retromock(retrofit: Retrofit) = Retromock.Builder().retrofit(retrofit).build()

    @Provides
    fun okHttpClient(sessionContract: SessionContract, logger: Logger): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(2, TimeUnit.MINUTES)
        .readTimeout(2, TimeUnit.MINUTES)
        .writeTimeout(2, TimeUnit.MINUTES)
        .addInterceptor(
            HttpLoggingInterceptor {
                logger.tag("okhttp").d(message = it)
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            },
        )
        .addInterceptor { chain ->
            runBlocking {
                val builder = chain.request().newBuilder()
                val token = sessionContract.getLocalAuthToken()
                val client = sessionContract.getLocalAuthClient()
                val uid = sessionContract.getLocalAuthUid()
                if (token.isNotEmpty() && client.isNotEmpty() && uid.isNotEmpty()) {
                    builder.addHeader("access-token", token)
                    builder.addHeader("client", client)
                    builder.addHeader("uid", uid)
                }
                chain.proceed(builder.build())
            }
        }
        .build()

    companion object {
        const val BASE_URL = "https://EXAMPLE.infinum.academy"
        const val MEDIA_TYPE_JSON = "application/json"
    }
}
