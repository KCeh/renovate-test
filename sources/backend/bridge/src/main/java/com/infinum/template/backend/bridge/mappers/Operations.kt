package com.infinum.template.backend.bridge.mappers

import com.infinum.template.backend.data.exceptions.RequestConverterException
import com.infinum.template.backend.data.exceptions.ResponseParsingException
import com.infinum.template.exceptions.AccessForbiddenException
import com.infinum.template.exceptions.ConflictException
import com.infinum.template.exceptions.NotFoundException
import com.infinum.template.exceptions.PreconditionException
import com.infinum.template.exceptions.UnexpectedContentException
import com.infinum.template.exceptions.UnprocessableEntityException
import java.net.HttpURLConnection
import retrofit2.HttpException

private const val HTTP_UNPROCESSABLE_ENTITY = 422

private fun Throwable.toDomain() = when (this) {
    is HttpException -> when (response()?.code()) {
        HttpURLConnection.HTTP_PRECON_FAILED -> PreconditionException(this)
        HttpURLConnection.HTTP_NOT_FOUND -> NotFoundException(this)
        HttpURLConnection.HTTP_FORBIDDEN -> AccessForbiddenException(this)
        HttpURLConnection.HTTP_CONFLICT -> ConflictException(this)
        HttpURLConnection.HTTP_UNAUTHORIZED -> ConflictException(this)
        HTTP_UNPROCESSABLE_ENTITY -> UnprocessableEntityException(this)
        // add mapping if we need to handle something else as well
        else -> this
    }
    is RequestConverterException, is ResponseParsingException -> UnexpectedContentException(this)
    // add mapping if we need to handle something else as well
    else -> this
}

internal suspend fun <T> bridge(block: suspend () -> T): T = try {
    block()
} catch (@Suppress("SwallowedException") error: Throwable) {
    throw error.toDomain()
}
