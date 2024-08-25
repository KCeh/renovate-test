package com.infinum.template.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

fun AppCompatActivity.repeatOnActivityLifecycle(
    state: Lifecycle.State = Lifecycle.State.STARTED,
    block: suspend () -> Unit,
) = lifecycleScope.launch {
    lifecycle.repeatOnLifecycle(state) {
        block()
    }
}
