package com.infinum.template.preferences.bridge.mapping

private fun Throwable.toDomain() = when (this) {
    // and others important for handling in the app
    else -> this
}

internal suspend fun <T> bridge(block: suspend () -> T): T = try {
    block()
} catch (@Suppress("SwallowedException") error: Throwable) {
    throw error.toDomain()
}
