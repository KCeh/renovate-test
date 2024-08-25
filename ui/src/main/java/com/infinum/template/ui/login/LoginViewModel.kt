package com.infinum.template.ui.login

import com.infinum.template.ui.R
import com.infinum.template.ui.shared.base.BaseViewModel
import com.infinum.template.ui.shared.validators.emailValidator
import com.infinum.template.ui.shared.validators.passwordValidator
import javax.inject.Inject

class LoginViewModel @Inject constructor() : BaseViewModel<LoginState, LoginEvent>(LoginState()) {

    fun onEmailChanged(email: String) {
        state = state.copy(email = state.email.copy(text = email, errorMessage = null))
    }

    fun onPasswordChanged(password: String) {
        state = state.copy(password = state.password.copy(text = password, errorMessage = null))
    }

    fun onRememberMeChanged(isChecked: Boolean) {
        state = state.copy(isRememberMeChecked = isChecked)
    }

    fun onLoginClicked() = with(state) {
        when {
            isEmailValid(email).not() && isPasswordValid(password).not() -> onEmailAndPasswordInvalid()
            isEmailValid(email).not() -> onEmailInvalid()
            isPasswordValid(password).not() -> onPasswordInvalid()
            else -> emitEvent(LoginEvent.ShowToast(R.string.log_in_clicked))
        }
    }

    fun onRegisterClicked() = emitEvent(LoginEvent.ShowToast(R.string.register_clicked))

    private fun isEmailValid(email: Input) = emailValidator.isValid(email.text)

    private fun isPasswordValid(password: Input) = passwordValidator.isValid(password.text)

    private fun onEmailAndPasswordInvalid() {
        state = state.copy(
            email = state.email.copy(errorMessage = R.string.error_email),
            password = state.password.copy(errorMessage = R.string.error_password),
        )
    }

    private fun onEmailInvalid() {
        state = state.copy(email = state.email.copy(errorMessage = R.string.error_email))
    }

    private fun onPasswordInvalid() {
        state = state.copy(password = state.password.copy(errorMessage = R.string.error_password))
    }
}
