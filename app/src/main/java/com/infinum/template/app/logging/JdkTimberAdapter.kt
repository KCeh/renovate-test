package com.infinum.template.app.logging

import com.infinum.template.common.logging.Logger
import timber.log.Timber

class JdkTimberAdapter : Logger {
    override fun v(message: String?, vararg args: Any?) = apply {
        Timber.v(message = message, args = args)
    }

    override fun v(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        Timber.v(t = cause, message = message, args = args)
    }

    override fun v(cause: Throwable?) = apply {
        Timber.v(t = cause)
    }

    override fun d(message: String?, vararg args: Any?) = apply {
        Timber.d(message = message, args = args)
    }

    override fun d(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        Timber.d(t = cause, message = message, args = args)
    }

    override fun d(cause: Throwable?) = apply {
        Timber.d(t = cause)
    }

    override fun i(message: String?, vararg args: Any?) = apply {
        Timber.i(message = message, args = args)
    }

    override fun i(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        Timber.i(t = cause, message = message, args = args)
    }

    override fun i(cause: Throwable?) = apply {
        Timber.i(t = cause)
    }

    override fun w(message: String?, vararg args: Any?) = apply {
        Timber.w(message = message, args = args)
    }

    override fun w(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        Timber.w(t = cause, message = message, args = args)
    }

    override fun w(cause: Throwable?) = apply {
        Timber.w(t = cause)
    }

    override fun e(message: String?, vararg args: Any?) = apply {
        Timber.e(message = message, args = args)
    }

    override fun e(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        Timber.e(t = cause, message = message, args = args)
    }

    override fun e(cause: Throwable?) = apply {
        Timber.e(t = cause)
    }

    override fun wtf(message: String?, vararg args: Any?) = apply {
        Timber.wtf(message = message, args = args)
    }

    override fun wtf(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        Timber.wtf(t = cause, message = message, args = args)
    }

    override fun wtf(cause: Throwable?) = apply {
        Timber.wtf(t = cause)
    }

    override fun tag(tag: String): Logger = apply {
        Timber.tag(tag)
    }
}
