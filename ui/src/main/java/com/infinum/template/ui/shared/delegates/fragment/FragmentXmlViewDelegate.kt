package com.infinum.template.ui.shared.delegates.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.infinum.template.extensions.repeatOnFragmentViewLifecycle
import com.infinum.template.ui.shared.base.BaseFragment

class FragmentXmlViewDelegate<State : Any, Event : Any>(
    private val fragment: BaseFragment<State, Event>,
    @LayoutRes private val layoutRes: Int?,
    private val handleState: ((State) -> Unit)? = null,
) : FragmentViewDelegate {

    override fun getView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutRes?.let { inflater.inflate(it, container, false) }
        with(fragment) {
            repeatOnFragmentViewLifecycle { provideBaseViewModel()?.stateFlow()?.collect { handleState?.invoke(it) } }
        }
        return view
    }
}

fun <State : Any, Event : Any> BaseFragment<State, Event>.xmlFragmentView(
    @LayoutRes layoutRes: Int? = null,
    handleState: ((State) -> Unit)? = null,
) = FragmentXmlViewDelegate(this, layoutRes, handleState)
