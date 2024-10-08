package com.infinum.template.ui.shared.delegates.fragment

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.asFlow
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FragmentViewBindingDelegate<T : ViewBinding>(
    val fragment: Fragment,
    val viewBindingFactory: (View) -> T,
) : ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null

    init {
        with(fragment) {
            lifecycleScope.launch {
                lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                    viewLifecycleOwnerLiveData
                        .asFlow()
                        .collectLatest {
                            if (it == null) {
                                binding = null
                            }
                        }
                }
            }
        }
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val existingBinding = binding
        return if (existingBinding != null) {
            existingBinding
        } else {
            if (
                fragment.viewLifecycleOwner
                    .lifecycle
                    .currentState
                    .isAtLeast(Lifecycle.State.INITIALIZED).not()
            ) {
                error("Fragment views are not created yet.")
            }

            viewBindingFactory(thisRef.requireView()).also { this.binding = it }
        }
    }
}

fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)
