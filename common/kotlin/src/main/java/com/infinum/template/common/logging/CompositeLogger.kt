package com.infinum.template.common.logging

/**
 * Composite logger that can be used to attach and detach multiple loggers.
 * This is useful when you want to log to multiple destinations.
 * For example, you can log to console and file at the same time.
 *
 */
internal class CompositeLogger : Logger {

    private val loggers = mutableListOf<Logger>()
    private var current = loggers.toTypedArray()

    /**
     * Attaches a new logger to the composite logger.
     *
     * @param logger Logger to attach.
     * @return Composite logger with the new logger attached.
     */
    fun attach(logger: Logger) = synchronized(loggers) {
        loggers.add(logger)
        current = loggers.toTypedArray()
    }

    /**
     * Detaches a logger from the composite logger.
     *
     * @param logger Logger to detach.
     * @return Composite logger with the logger detached.
     */
    fun detach(logger: Logger) = synchronized(loggers) {
        loggers.remove(logger)
        current = loggers.toTypedArray()
    }

    override fun v(message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.v(message = message, args = args) }
    }

    override fun v(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.v(cause = cause, message = message, args = args) }
    }

    override fun v(cause: Throwable?) = apply {
        current.forEach { logger -> logger.v(cause = cause) }
    }

    override fun d(message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.d(message = message, args = args) }
    }

    override fun d(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.d(cause = cause, message = message, args = args) }
    }

    override fun d(cause: Throwable?) = apply {
        current.forEach { logger -> logger.d(cause = cause) }
    }

    override fun i(message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.i(message = message, args = args) }
    }

    override fun i(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.i(cause = cause, message = message, args = args) }
    }

    override fun i(cause: Throwable?) = apply {
        current.forEach { logger -> logger.i(cause = cause) }
    }

    override fun w(message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.w(message = message, args = args) }
    }

    override fun w(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.w(cause = cause, message = message, args = args) }
    }

    override fun w(cause: Throwable?) = apply {
        current.forEach { logger -> logger.w(cause = cause) }
    }

    override fun e(message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.e(message = message, args = args) }
    }

    override fun e(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.e(cause = cause, message = message, args = args) }
    }

    override fun e(cause: Throwable?) = apply {
        current.forEach { logger -> logger.e(cause = cause) }
    }

    override fun wtf(message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.wtf(message = message, args = args) }
    }

    override fun wtf(cause: Throwable?, message: String?, vararg args: Any?) = apply {
        current.forEach { logger -> logger.wtf(cause = cause, message = message, args = args) }
    }

    override fun wtf(cause: Throwable?) = apply {
        current.forEach { logger -> logger.wtf(cause = cause) }
    }

    override fun tag(tag: String): Logger = apply {
        current.forEach { logger -> logger.tag(tag = tag) }
    }
}
