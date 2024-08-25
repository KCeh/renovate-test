package com.infinum.template.ui.shared.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.infinum.template.extensions.repeatOnFragmentViewLifecycle
import com.infinum.template.ui.shared.architecture.CommonState
import com.infinum.template.ui.shared.architecture.ErrorState
import com.infinum.template.ui.shared.architecture.LoadingState
import com.infinum.template.ui.shared.delegates.fragment.FragmentViewDelegate
import dagger.android.support.DaggerFragment

/**
 * Base [DaggerFragment] class which all Fragments inside the project must extend. Override [provideBaseViewModel] with concrete
 * [BaseViewModel] implementation and [handleEvent] for handling [Event].
 *
 * @param State defines view state of the [BaseFragment]
 * @param Event defines view event of the [BaseFragment]
 */
abstract class BaseFragment<State : Any, Event : Any> : DaggerFragment() {

    protected abstract val viewDelegate: FragmentViewDelegate
    abstract fun provideBaseViewModel(): BaseViewModel<State, Event>?
    protected abstract fun handleEvent(event: Event)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        viewDelegate.getView(inflater, container, savedInstanceState)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        provideBaseViewModel()?.let { viewModel ->
            repeatOnFragmentViewLifecycle { viewModel.commonStateFlow().collect(::handleCommonState) }
            repeatOnFragmentViewLifecycle { viewModel.eventFlow().collect(::handleEvent) }
        }
    }

    protected open fun handleLoading() {}

    protected open fun handleIdle() {}

    protected open fun handleUnknownError() {}

    protected open fun handleError(@StringRes messageRes: Int) {}

    private fun handleCommonState(commonState: CommonState) {
        handleLoadingState(commonState.loadingState)
        handleErrorState(commonState.errorState)
    }

    private fun handleLoadingState(loadingState: LoadingState) {
        when (loadingState) {
            is LoadingState.Loading -> handleLoading()
            is LoadingState.Idle -> handleIdle()
        }
    }

    private fun handleErrorState(errorState: ErrorState) {
        when (errorState) {
            is ErrorState.UnknownError -> handleUnknownError()
            is ErrorState.Error -> handleError(errorState.messageRes)
            ErrorState.NoError -> Unit
        }
    }
}
