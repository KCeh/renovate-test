package com.infinum.template.ui.shared.composables

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.infinum.template.ui.R
import com.infinum.template.ui.shared.compose.TemplateTheme

/**
 * [Composable] function of project custom [Scaffold] for using across the app.
 * @param title for setting title
 * @param modifier optional [Modifier] for modifying behavior,
 * @param navigation data class which contains navigation icon and click listener
 * @param topBar for displaying toolbar on the top of [Scaffold]. Default is [TemplateTopAppBar].
 * @param content for defining [Composable] functions that will be placed below [topBar]
 */
@Composable
fun TemplateScaffold(
    title: String,
    modifier: Modifier = Modifier,
    navigation: Navigation? = null,
    topBar: @Composable () -> Unit = { TemplateTopAppBar(title = title, navigation = navigation) },
    content: @Composable (PaddingValues) -> Unit,
) = Scaffold(
    modifier = modifier,
    topBar = topBar,
    content = content,
)

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun TemplateScaffoldPreview() = TemplateTheme {
    TemplateScaffold(
        title = stringResource(id = R.string.application_name),
        content = {},
    )
}
