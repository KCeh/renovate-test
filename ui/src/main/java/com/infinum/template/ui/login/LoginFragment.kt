package com.infinum.template.ui.login

import com.infinum.template.di.qualifiers.ViewModelInjection
import com.infinum.template.extensions.showToast
import com.infinum.template.ui.shared.base.BaseFragment
import com.infinum.template.ui.shared.delegates.fragment.composeFragmentView
import javax.inject.Inject

class LoginFragment : BaseFragment<LoginState, LoginEvent>() {

    @Inject
    @ViewModelInjection
    lateinit var viewModel: LoginViewModel

    override val viewDelegate = composeFragmentView { state ->
        LoginScreen(
            state = state,
            onEmailChange = viewModel::onEmailChanged,
            onPasswordChange = viewModel::onPasswordChanged,
            onRememberMeChange = viewModel::onRememberMeChanged,
            onLoginClick = viewModel::onLoginClicked,
            onRegisterClick = viewModel::onRegisterClicked,
        )
    }

    override fun provideBaseViewModel() = viewModel

    override fun handleEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.ShowToast -> showToast(getString(event.resId))
        }
    }
}
