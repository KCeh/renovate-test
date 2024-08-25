package com.infinum.template.ui.shared.composables

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.infinum.template.ui.R
import com.infinum.template.ui.shared.compose.TemplateTheme
import com.infinum.template.ui.shared.providers.BooleanParameterProvider

/**
 * [Composable] function of project custom [Checkbox] for using across the app.
 * @param text that will be displayed after the [Checkbox]
 * @param isChecked which represent if [Checkbox] is checked or not
 * @param onCheckedChange that will be invoked when [Checkbox] state changed
 * @param modifier optional [Modifier] for modifying behavior
 */
@Composable
fun TemplateCheckbox(
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val checkboxTextClick = remember(isChecked, onCheckedChange) { { onCheckedChange(isChecked.not()) } }
    Row(modifier = modifier) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            interactionSource = interactionSource,
        )
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = checkboxTextClick,
                )
                .padding(horizontal = dimensionResource(id = R.dimen.spacing_2x)),
            text = text,
        )
    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun TemplateCheckBoxPreview(@PreviewParameter(BooleanParameterProvider::class) isChecked: Boolean) = TemplateTheme {
    Surface {
        TemplateCheckbox(
            text = stringResource(id = R.string.remember_me),
            isChecked = isChecked,
            onCheckedChange = {},
        )
    }
}
