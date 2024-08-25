package com.infinum.template.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

fun Fragment.repeatOnFragmentViewLifecycle(
    state: Lifecycle.State = Lifecycle.State.STARTED,
    block: suspend () -> Unit,
) = viewLifecycleOwner.lifecycleScope.launch {
    viewLifecycleOwner.lifecycle.repeatOnLifecycle(state) {
        block()
    }
}

fun Fragment.showToast(
    text: String,
    length: Int = Toast.LENGTH_SHORT,
) = Toast.makeText(requireContext(), text, length).show()
