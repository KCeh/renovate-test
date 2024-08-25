package com.infinum.template.room.bridge.mappers

import android.database.sqlite.SQLiteConstraintException
import com.infinum.template.exceptions.DuplicationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

private fun Throwable.toDomain() = when (this) {
    // and others important for handling in the app
    is SQLiteConstraintException -> DuplicationException(this)
    else -> this
}

internal suspend fun <T> bridge(block: suspend () -> T): T = try {
    block()
} catch (@Suppress("SwallowedException") error: Throwable) {
    throw error.toDomain()
}

internal fun <T> Flow<T>.bridge() = catch { error -> throw error.toDomain() }
