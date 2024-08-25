package com.infinum.template.ui.shared.delegates.activity

import androidx.annotation.LayoutRes
import com.infinum.template.extensions.repeatOnActivityLifecycle
import com.infinum.template.ui.shared.base.BaseActivity

class ActivityXmlContentDelegate<State : Any, Event : Any>(
    private val activity: BaseActivity<State, Event>,
    @LayoutRes private val layoutRes: Int? = null,
    private val handleState: ((State) -> Unit)? = null,
) : ActivityContentDelegate {

    override fun initContent() {
        with(activity) {
            layoutRes?.let { setContentView(it) }
            repeatOnActivityLifecycle { provideBaseViewModel()?.stateFlow()?.collect { handleState?.invoke(it) } }
        }
    }
}

fun <State : Any, Event : Any> BaseActivity<State, Event>.xmlActivityContent(
    @LayoutRes layoutRes: Int? = null,
    handleState: ((State) -> Unit)? = null,
) = ActivityXmlContentDelegate(this, layoutRes, handleState)
