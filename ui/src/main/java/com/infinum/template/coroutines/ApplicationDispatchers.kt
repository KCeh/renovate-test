package com.infinum.template.coroutines

import kotlinx.coroutines.CoroutineDispatcher

data class ApplicationDispatchers(
    val default: CoroutineDispatcher,
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher,
)
