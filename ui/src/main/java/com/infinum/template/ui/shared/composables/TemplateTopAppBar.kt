package com.infinum.template.ui.shared.composables

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.infinum.template.ui.R
import com.infinum.template.ui.shared.compose.TemplateTheme

data class Navigation(@DrawableRes val iconResId: Int, val onIconClick: () -> Unit)

/**
 * [Composable] function of project custom [TopAppBar] for using across the app.
 * @param title for setting title
 * @param modifier optional [Modifier] for modifying behavior
 * @param navigation data class which contains navigation icon and click listener
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemplateTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigation: Navigation? = null,
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            navigation?.let {
                with(it) {
                    IconButton(
                        modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.spacing_2x)),
                        onClick = onIconClick,
                    ) {
                        Icon(
                            modifier = Modifier.size(dimensionResource(id = R.dimen.spacing_3x)),
                            painter = painterResource(id = iconResId),
                            contentDescription = stringResource(id = R.string.navigation_icon_content_description),
                        )
                    }
                }
            }
        },
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = TemplateTheme.colors.primary,
            titleContentColor = TemplateTheme.colors.onPrimary,
        ),
    )
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun TemplateTopAppBarPreview() = TemplateTheme {
    TemplateTopAppBar(
        title = stringResource(id = R.string.application_name),
    )
}
