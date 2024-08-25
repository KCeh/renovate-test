package com.infinum.template.ui.shared.composables

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.infinum.template.ui.R
import com.infinum.template.ui.shared.compose.TemplateTheme

/**
 * A custom [OutlinedTextField] for usage across the app. It supports password functionality out-of-the-box.
 *
 * @param hint that will be set inside the [OutlinedTextField]
 * @param text that will be displayed inside the [OutlinedTextField]
 * @param onTextChange that will be invoked whenever text inside [OutlinedTextField] change
 * @param modifier optional [Modifier] for modifying behavior
 * @param errorText that will be displayed under the component.
 * @param trailingIcon that will be set at the end of [OutlinedTextField]
 * @param keyboardOptions for modifying input type, ime action, etc.
 * @param keyboardActions function that will be invoked whenever any ime option clicked
 * @param singleLine defines is [text] displayed inside [OutlinedTextField] is multiline or not
 */
@Composable
fun TemplateOutlinedTextField(
    hint: String?,
    text: String?,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    @StringRes errorText: Int? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
) {
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }
    val isPasswordKeyboardType = rememberSaveable(keyboardOptions) {
        with(keyboardOptions) { (keyboardType == KeyboardType.Password).or(keyboardType == KeyboardType.NumberPassword) }
    }
    val passwordTrailingIconClick = remember { { isPasswordVisible = isPasswordVisible.not() } }
    OutlinedTextField(
        modifier = modifier,
        value = text.orEmpty(),
        onValueChange = onTextChange,
        label = { Text(text = hint.orEmpty()) },
        isError = errorText != null,
        singleLine = singleLine,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        visualTransformation = if (isPasswordKeyboardType && isPasswordVisible.not()) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        trailingIcon = {
            if (isPasswordKeyboardType) {
                PasswordTextFieldTrailingIcon(
                    isPasswordVisible = isPasswordVisible,
                    onTrailingIconClick = passwordTrailingIconClick,
                )
            } else {
                trailingIcon?.invoke()
            }
        },
        supportingText = { errorText?.let { Text(text = stringResource(id = it)) } },
    )
}

@Composable
private fun PasswordTextFieldTrailingIcon(isPasswordVisible: Boolean, onTrailingIconClick: () -> Unit) {
    val icon = if (isPasswordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
    IconButton(onClick = onTrailingIconClick) {
        Icon(
            imageVector = icon,
            contentDescription = stringResource(id = R.string.password_trailing_icon_content_description),
            tint = TemplateTheme.colors.primary,
        )
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun TemplateOutlinedTextFieldPreview() = TemplateTheme {
    Surface {
        TemplateOutlinedTextField(
            hint = stringResource(R.string.email),
            text = null,
            onTextChange = { _ -> },
        )
    }
}
