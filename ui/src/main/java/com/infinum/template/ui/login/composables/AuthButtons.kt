package com.infinum.template.ui.login.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.infinum.template.ui.R
import com.infinum.template.ui.shared.composables.TemplateButton
import com.infinum.template.ui.shared.composables.TemplateOutlinedButton
import com.infinum.template.ui.shared.compose.TemplateTheme

@Composable
fun AuthButtons(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier,
) = Column(modifier = modifier) {
    TemplateButton(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = R.string.log_in),
        onClick = onLoginClick,
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_2x)))
    Text(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        text = stringResource(id = R.string.or),
        style = TemplateTheme.typography.bodySmall,
        color = TemplateTheme.colors.onBackground,
    )
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_2x)))
    TemplateOutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(id = R.string.register),
        onClick = onRegisterClick,
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AuthButtonsPreview() = TemplateTheme {
    AuthButtons(onLoginClick = {}, onRegisterClick = {})
}
