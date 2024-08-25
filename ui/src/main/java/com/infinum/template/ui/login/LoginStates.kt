package com.infinum.template.ui.login

import androidx.annotation.StringRes

data class Input(
    val text: String = "",
    @StringRes val errorMessage: Int? = null,
)

data class LoginState(
    val email: Input = Input(),
    val password: Input = Input(),
    val isRememberMeChecked: Boolean = false,
)

sealed interface LoginEvent {
    data class ShowToast(@StringRes val resId: Int) : LoginEvent
}
