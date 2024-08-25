package com.infinum.template.ui.shared.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object TemplateTheme {

    val colors: DefaultColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: DefaultTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: DefaultShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}

@Composable
fun TemplateTheme(
    colors: DefaultColors = if (isSystemInDarkTheme()) DarkColors() else LightColors(),
    typography: DefaultTypography = Typography(),
    shapes: DefaultShapes = Shapes(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalShapes provides shapes,
        LocalTypography provides typography,
    ) {
        MaterialTheme(
            colorScheme = colors.material,
            typography = typography.material,
            shapes = shapes.material,
            content = content,
        )
    }
}
