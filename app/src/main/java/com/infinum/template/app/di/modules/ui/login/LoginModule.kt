package com.infinum.template.app.di.modules.ui.login

import com.infinum.template.di.providers.InjectionViewModelProvider
import com.infinum.template.di.qualifiers.ViewModelInjection
import com.infinum.template.ui.login.LoginFragment
import com.infinum.template.ui.login.LoginViewModel
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    @ViewModelInjection
    fun viewModel(
        provider: InjectionViewModelProvider<LoginViewModel>,
        fragment: LoginFragment,
    ): LoginViewModel = provider.provide(fragment)
}
