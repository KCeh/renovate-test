package com.infinum.template.common.logging

private val delegate = CompositeLogger()

/**
 * Logger static api that can be used to log to multiple loggers attached to this instance.
 */
object JdkTimber : Logger by delegate {

    @JvmStatic
    fun attach(logger: Logger) {
        delegate.attach(logger)
    }

    @JvmStatic
    fun detach(logger: Logger) {
        delegate.detach(logger)
    }
}
