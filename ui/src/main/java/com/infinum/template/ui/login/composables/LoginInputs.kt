package com.infinum.template.ui.login.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.infinum.template.ui.R
import com.infinum.template.ui.shared.composables.TemplateOutlinedTextField
import com.infinum.template.ui.shared.compose.TemplateTheme

@Composable
fun LoginInputs(
    email: String,
    emailErrorMessage: Int?,
    onEmailChange: (String) -> Unit,
    password: String,
    passwordErrorMessage: Int?,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    focusManager: FocusManager = LocalFocusManager.current,
    mailKeyboardOptions: KeyboardOptions = remember { KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next) },
    passwordKeyboardOptions: KeyboardOptions = remember {
        KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
        )
    },
    mailKeyboardActions: KeyboardActions = remember { KeyboardActions { focusManager.moveFocus(FocusDirection.Down) } },
    passwordKeyboardActions: KeyboardActions = remember { KeyboardActions { focusManager.clearFocus() } },
) = Column(modifier) {
    TemplateOutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        hint = stringResource(id = R.string.email),
        text = email,
        onTextChange = onEmailChange,
        errorText = emailErrorMessage,
        keyboardOptions = mailKeyboardOptions,
        keyboardActions = mailKeyboardActions,
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_2x)))
    TemplateOutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        hint = stringResource(id = R.string.password),
        text = password,
        onTextChange = onPasswordChange,
        errorText = passwordErrorMessage,
        keyboardOptions = passwordKeyboardOptions,
        keyboardActions = passwordKeyboardActions,
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoginInputsPreview() = TemplateTheme {
    LoginInputs(
        email = "",
        emailErrorMessage = null,
        onEmailChange = {},
        password = "",
        passwordErrorMessage = null,
        onPasswordChange = {},
    )
}
