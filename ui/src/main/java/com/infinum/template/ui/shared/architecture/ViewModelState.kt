package com.infinum.template.ui.shared.architecture

import androidx.annotation.StringRes

data class CommonState(
    val loadingState: LoadingState = LoadingState.Idle,
    val errorState: ErrorState = ErrorState.NoError,
)

sealed class LoadingState {

    object Idle : LoadingState()
    object Loading : LoadingState()
}

sealed class ErrorState {

    object NoError : ErrorState()
    object UnknownError : ErrorState()
    data class Error(@StringRes val messageRes: Int) : ErrorState()
}
