package com.infinum.template.extensions

import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.infinum.template.ui.shared.base.BaseViewModel
import com.infinum.template.ui.shared.compose.TemplateTheme
import kotlinx.coroutines.flow.map

/**
 * [ComposeView] extension function for applying custom theming to [Composable] written inside the [content] block.
 *
 * @param viewCompositionStrategy for managing dispose of [ComposeView]
 * @param content for writting [Composable] functions
 */
fun ComposeView.applyTemplateTheme(
    viewCompositionStrategy: ViewCompositionStrategy = ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed,
    content: @Composable () -> Unit,
): View {
    setContent {
        setViewCompositionStrategy(viewCompositionStrategy)
        TemplateTheme(content = content)
    }
    return this
}

/**
 * [ComposeView] extension function for collecting [SubState] of the [State] in lifecycle aware manner to avoid unnecessary compositions.
 *
 * @param State the type of [BaseViewModel]'s view state
 * @param Event the type of [BaseViewModel]'s events
 * @param SubState the type of [BaseViewModel]'s substate
 * @param viewModel needed for collecting [State]
 * @param subState calculation function for defining which subset of [State] will be collected
 * @param block [Composable] block that will be invoked when specified [subState] changed
 */
fun <State : Any, Event : Any, SubState : Any> ComposeView.collectAsSubStateWithLifecycle(
    viewModel: BaseViewModel<State, Event>,
    subState: (State) -> SubState?,
    block: @Composable (subState: SubState?) -> Unit,
) = applyTemplateTheme {
    val rememberSubStateFlow = remember { viewModel.stateFlow().map { subState(it) } }
    val rememberInitialSubStateValue = remember { subState(viewModel.stateFlow().value) }
    rememberSubStateFlow.collectAsStateWithLifecycle(initialValue = rememberInitialSubStateValue).value.also { subState -> block(subState) }
}
