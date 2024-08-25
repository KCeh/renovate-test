package com.infinum.template.ui.shared.delegates.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.infinum.template.extensions.applyTemplateTheme
import com.infinum.template.ui.shared.base.BaseFragment

class FragmentComposeViewDelegate<State : Any, Event : Any>(
    private val fragment: BaseFragment<State, Event>,
    private val composeState: (@Composable (State) -> Unit)? = null,
) : FragmentViewDelegate {

    override fun getView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        ComposeView(fragment.requireContext()).applyTemplateTheme {
            fragment.provideBaseViewModel()?.stateFlow()?.collectAsStateWithLifecycle()?.value?.let { composeState?.invoke(it) }
        }
}

fun <State : Any, Event : Any> BaseFragment<State, Event>.composeFragmentView(composeState: (@Composable (State) -> Unit)? = null) =
    FragmentComposeViewDelegate(this, composeState)
