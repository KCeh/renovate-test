package com.infinum.template.common.logging

@Suppress("FunctionMinLength")
interface Logger {
    /** Log a verbose message with optional format args. */
    fun v(message: String?, vararg args: Any?): Logger

    /** Log a verbose exception and a message with optional format args. */
    fun v(cause: Throwable?, message: String?, vararg args: Any?): Logger

    /** Log a verbose exception. */
    fun v(cause: Throwable?): Logger

    /** Log a debug message with optional format args. */
    fun d(message: String?, vararg args: Any?): Logger

    /** Log a debug exception and a message with optional format args. */
    fun d(cause: Throwable?, message: String?, vararg args: Any?): Logger

    /** Log a debug exception. */
    fun d(cause: Throwable?): Logger

    /** Log an info message with optional format args. */
    fun i(message: String?, vararg args: Any?): Logger

    /** Log an info exception and a message with optional format args. */
    fun i(cause: Throwable?, message: String?, vararg args: Any?): Logger

    /** Log an info exception. */
    fun i(cause: Throwable?): Logger

    /** Log a warning message with optional format args. */
    fun w(message: String?, vararg args: Any?): Logger

    /** Log a warning exception and a message with optional format args. */
    fun w(cause: Throwable?, message: String?, vararg args: Any?): Logger

    /** Log a warning exception. */
    fun w(cause: Throwable?): Logger

    /** Log an error message with optional format args. */
    fun e(message: String?, vararg args: Any?): Logger

    /** Log an error exception and a message with optional format args. */
    fun e(cause: Throwable?, message: String?, vararg args: Any?): Logger

    /** Log an error exception. */
    fun e(cause: Throwable?): Logger

    /** Log an assert message with optional format args. */
    fun wtf(message: String?, vararg args: Any?): Logger

    /** Log an assert exception and a message with optional format args. */
    fun wtf(cause: Throwable?, message: String?, vararg args: Any?): Logger

    /** Log an assert exception. */
    fun wtf(cause: Throwable?): Logger

    /** Set a one-time tag for use on the next logging call. */
    fun tag(tag: String): Logger
}
