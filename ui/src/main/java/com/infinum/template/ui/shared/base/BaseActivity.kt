package com.infinum.template.ui.shared.base

import android.os.Bundle
import androidx.annotation.StringRes
import com.infinum.template.extensions.repeatOnActivityLifecycle
import com.infinum.template.ui.shared.architecture.CommonState
import com.infinum.template.ui.shared.architecture.ErrorState
import com.infinum.template.ui.shared.architecture.LoadingState
import com.infinum.template.ui.shared.delegates.activity.ActivityContentDelegate
import dagger.android.support.DaggerAppCompatActivity

/**
 * Base [DaggerAppCompatActivity] class which all Activities inside the project must extend. Override [provideBaseViewModel] with concrete
 * [BaseViewModel] implementation and [handleEvent] for handling [Event].
 *
 * @param State defines view state of the [BaseActivity]
 * @param Event defines view event of the [BaseActivity]
 */
abstract class BaseActivity<State : Any, Event : Any> : DaggerAppCompatActivity() {

    protected abstract val contentDelegate: ActivityContentDelegate
    abstract fun provideBaseViewModel(): BaseViewModel<State, Event>?
    protected abstract fun handleEvent(event: Event)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentDelegate.initContent()
        initCollectors()
    }

    private fun initCollectors() = provideBaseViewModel()?.let { viewModel ->
        repeatOnActivityLifecycle { viewModel.commonStateFlow().collect(::handleCommonState) }
        repeatOnActivityLifecycle { viewModel.eventFlow().collect(::handleEvent) }
    }

    protected open fun handleLoading() {}

    protected open fun handleIdle() {}

    protected open fun handleUnknownError() {}

    protected open fun handleError(@StringRes messageRes: Int) {}

    private fun handleCommonState(commonState: CommonState) {
        handleLoadingState(commonState.loadingState)
        handleErrorState(commonState.errorState)
    }

    private fun handleLoadingState(loadingState: LoadingState) = when (loadingState) {
        is LoadingState.Loading -> handleLoading()
        is LoadingState.Idle -> handleIdle()
    }

    private fun handleErrorState(errorState: ErrorState) {
        when (errorState) {
            is ErrorState.UnknownError -> handleUnknownError()
            is ErrorState.Error -> handleError(errorState.messageRes)
            ErrorState.NoError -> Unit
        }
    }
}
