package com.infinum.template.ui.shared.delegates.activity

import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.infinum.template.ui.shared.base.BaseActivity
import com.infinum.template.ui.shared.compose.TemplateTheme

class ActivityComposeContentDelegate<State : Any, Event : Any>(
    private val activity: BaseActivity<State, Event>,
    private val composeState: (@Composable (State) -> Unit)? = null,
) : ActivityContentDelegate {

    override fun initContent() {
        with(activity) {
            setContent {
                TemplateTheme {
                    provideBaseViewModel()?.stateFlow()?.collectAsStateWithLifecycle()?.value?.let { composeState?.invoke(it) }
                }
            }
        }
    }
}

fun <State : Any, Event : Any> BaseActivity<State, Event>.composeActivityContent(
    composeState: (@Composable (State) -> Unit)? = null,
) = ActivityComposeContentDelegate(this, composeState)
