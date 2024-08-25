package com.infinum.template.ui.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.infinum.template.ui.R
import com.infinum.template.ui.login.composables.AuthButtons
import com.infinum.template.ui.login.composables.LoginInputs
import com.infinum.template.ui.shared.composables.TemplateCheckbox
import com.infinum.template.ui.shared.composables.TemplateScaffold
import com.infinum.template.ui.shared.compose.TemplateTheme

@Composable
fun LoginScreen(
    state: LoginState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRememberMeChange: (Boolean) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
) = with(state) {
    TemplateScaffold(modifier = modifier, title = stringResource(id = R.string.application_name)) {
        Surface(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = dimensionResource(id = R.dimen.spacing_2x)),
            ) {
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_6x)))
                Image(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_6x)))
                LoginInputs(
                    email = email.text,
                    emailErrorMessage = email.errorMessage,
                    onEmailChange = onEmailChange,
                    password = password.text,
                    passwordErrorMessage = password.errorMessage,
                    onPasswordChange = onPasswordChange,
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_2x)))
                TemplateCheckbox(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.remember_me),
                    isChecked = isRememberMeChecked,
                    onCheckedChange = onRememberMeChange,
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_3x)))
                AuthButtons(
                    onLoginClick = onLoginClick,
                    onRegisterClick = onRegisterClick,
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_3x)))
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoginScreenPreview() = TemplateTheme {
    LoginScreen(
        state = LoginState(),
        onEmailChange = {},
        onPasswordChange = {},
        onRememberMeChange = {},
        onLoginClick = {},
        onRegisterClick = {},
    )
}
