package com.infinum.template.backend.data.internal.converters

import com.infinum.template.backend.data.exceptions.RequestConverterException
import com.infinum.template.backend.data.exceptions.ResponseParsingException
import java.io.IOException
import java.lang.reflect.Type
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

internal class ParsingConverter<F : Any, T>(
    private val delegate: Converter<F, T>,
    private val isRequest: Boolean = false,
) : Converter<F, T> {
    override fun convert(value: F): T? = try {
        delegate.convert(value)
    } catch (exception: IOException) {
        throw if (isRequest) {
            RequestConverterException(exception)
        } else {
            ResponseParsingException(exception)
        }
    }

    class Factory(
        private val delegate: Converter.Factory,
    ) : Converter.Factory() {
        override fun responseBodyConverter(
            type: Type,
            annotations: Array<out Annotation>,
            retrofit: Retrofit,
        ): Converter<ResponseBody, *>? = delegate.responseBodyConverter(type, annotations, retrofit)?.wrap()

        override fun requestBodyConverter(
            type: Type,
            parameterAnnotations: Array<out Annotation>,
            methodAnnotations: Array<out Annotation>,
            retrofit: Retrofit,
        ): Converter<*, RequestBody>? = delegate.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)?.wrap()

        override fun stringConverter(type: Type, annotations: Array<out Annotation>, retrofit: Retrofit): Converter<*, String>? =
            delegate.stringConverter(type, annotations, retrofit)

        private fun <F : Any, T> Converter<F, T>.wrap() = ParsingConverter(this)
    }
}
