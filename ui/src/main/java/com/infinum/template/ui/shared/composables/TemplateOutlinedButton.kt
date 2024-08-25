package com.infinum.template.ui.shared.composables

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.infinum.template.ui.R
import com.infinum.template.ui.shared.compose.TemplateTheme

/**
 * [Composable] function of project custom [OutlinedButton] for using across the app.
 * @param text that will be displayed
 * @param onClick that will be invoked when [Button] is clicked
 * @param modifier optional [Modifier] for modifying behavior
 */
@Composable
fun TemplateOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) = OutlinedButton(
    onClick = onClick,
    modifier = modifier,
    contentPadding = PaddingValues(dimensionResource(id = R.dimen.spacing_2x)),
) {
    Text(
        text = text,
        style = TemplateTheme.typography.bodyLarge,
    )
}

@Preview(widthDp = 300)
@Preview(widthDp = 300, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun TemplateOutlinedButtonPreview() = TemplateTheme {
    Surface {
        TemplateOutlinedButton(
            text = stringResource(id = R.string.register),
            onClick = {},
        )
    }
}
