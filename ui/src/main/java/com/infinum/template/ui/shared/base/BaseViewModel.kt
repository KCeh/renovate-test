@file:Suppress("PropertyName")

package com.infinum.template.ui.shared.base

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.infinum.template.ui.shared.SingleSubscriberFlow
import com.infinum.template.ui.shared.architecture.CommonState
import com.infinum.template.ui.shared.architecture.ErrorState
import com.infinum.template.ui.shared.architecture.LoadingState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel<State : Any, Event : Any>(initialState: State) : ViewModel() {

    private val baseExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Timber.e(throwable)
        showUnknownError()
    }

    private val stateFlow: MutableStateFlow<State> = MutableStateFlow(initialState)
    private val commonStateFlow = MutableStateFlow(CommonState())
    private val eventChannel: Channel<Event> = Channel(capacity = 1)

    private var commonState: CommonState
        get() = commonStateFlow.value
        set(value) = commonStateFlow.update { value }

    protected var state: State
        get() = stateFlow.value
        set(value) = stateFlow.update { value }

    fun stateFlow(): StateFlow<State> = stateFlow
    fun commonStateFlow(): StateFlow<CommonState> = commonStateFlow
    fun eventFlow(): Flow<Event> = SingleSubscriberFlow(eventChannel.receiveAsFlow())

    protected fun launch(
        exceptionHandler: CoroutineExceptionHandler = baseExceptionHandler,
        block: suspend () -> Unit,
    ) = viewModelScope.launch(exceptionHandler) {
        block()
    }

    protected fun launchWithLoading(
        exceptionHandler: CoroutineExceptionHandler = baseExceptionHandler,
        block: suspend () -> Unit,
    ) = viewModelScope.launch(exceptionHandler) {
        try {
            showLoading()
            block()
        } finally {
            hideLoading()
        }
    }

    protected fun emitEvent(event: Event) {
        eventChannel.trySend(event)
    }

    protected fun showLoading() {
        commonState = commonState.copy(loadingState = LoadingState.Loading)
    }

    protected fun hideLoading() {
        commonState = commonState.copy(loadingState = LoadingState.Idle)
    }

    protected fun showError(@StringRes messageRes: Int) {
        commonState = commonState.copy(errorState = ErrorState.Error(messageRes))
    }

    protected fun showUnknownError() {
        commonState = commonState.copy(errorState = ErrorState.UnknownError)
    }

    protected fun clearCommonState() {
        commonState = CommonState()
    }
}
