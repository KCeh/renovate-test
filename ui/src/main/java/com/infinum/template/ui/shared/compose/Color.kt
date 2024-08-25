package com.infinum.template.ui.shared.compose

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val infinumRed = Color(0xFFD82828)

interface DefaultColors {
    val primary: Color
    val onPrimary: Color
    val primaryContainer: Color
    val onPrimaryContainer: Color
    val inversePrimary: Color
    val secondary: Color
    val onSecondary: Color
    val secondaryContainer: Color
    val onSecondaryContainer: Color
    val tertiary: Color
    val onTertiary: Color
    val tertiaryContainer: Color
    val onTertiaryContainer: Color
    val background: Color
    val onBackground: Color
    val surface: Color
    val onSurface: Color
    val surfaceVariant: Color
    val onSurfaceVariant: Color
    val surfaceTint: Color
    val inverseSurface: Color
    val inverseOnSurface: Color
    val error: Color
    val onError: Color
    val errorContainer: Color
    val onErrorContainer: Color
    val outline: Color
    val outlineVariant: Color
    val scrim: Color
    val material: ColorScheme
}

data class LightColors(
    override val primary: Color = infinumRed,
    override val onPrimary: Color = Color.White,
    override val primaryContainer: Color = Color.Black,
    override val onPrimaryContainer: Color = Color.White,
    override val inversePrimary: Color = Color.White,
    override val secondary: Color = Color.White,
    override val onSecondary: Color = Color.Black,
    override val secondaryContainer: Color = Color.Black,
    override val onSecondaryContainer: Color = Color.White,
    override val tertiary: Color = Color.Black,
    override val onTertiary: Color = Color.White,
    override val tertiaryContainer: Color = Color.Black,
    override val onTertiaryContainer: Color = Color.White,
    override val background: Color = Color.White,
    override val onBackground: Color = Color.Black,
    override val surface: Color = Color.White,
    override val onSurface: Color = Color.Black,
    override val surfaceVariant: Color = Color.White,
    override val onSurfaceVariant: Color = Color.Black,
    override val surfaceTint: Color = Color.White,
    override val inverseSurface: Color = Color.Black,
    override val inverseOnSurface: Color = Color.White,
    override val error: Color = infinumRed,
    override val onError: Color = Color.White,
    override val errorContainer: Color = Color.Black,
    override val onErrorContainer: Color = Color.White,
    override val outline: Color = Color.Black,
    override val outlineVariant: Color = Color.White,
    override val scrim: Color = Color.Black,
) : DefaultColors {

    override val material = ColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onError,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
    )
}

data class DarkColors(
    override val primary: Color = infinumRed,
    override val onPrimary: Color = Color.Black,
    override val primaryContainer: Color = Color.Black,
    override val onPrimaryContainer: Color = Color.White,
    override val inversePrimary: Color = Color.Black,
    override val secondary: Color = Color.Black,
    override val onSecondary: Color = Color.White,
    override val secondaryContainer: Color = Color.Black,
    override val onSecondaryContainer: Color = Color.White,
    override val tertiary: Color = Color.Black,
    override val onTertiary: Color = Color.White,
    override val tertiaryContainer: Color = Color.Black,
    override val onTertiaryContainer: Color = Color.White,
    override val background: Color = Color.Black,
    override val onBackground: Color = Color.White,
    override val surface: Color = Color.Black,
    override val onSurface: Color = Color.White,
    override val surfaceVariant: Color = Color.Black,
    override val onSurfaceVariant: Color = Color.White,
    override val surfaceTint: Color = Color.Black,
    override val inverseSurface: Color = Color.Black,
    override val inverseOnSurface: Color = Color.White,
    override val error: Color = infinumRed,
    override val onError: Color = Color.White,
    override val errorContainer: Color = Color.Black,
    override val onErrorContainer: Color = Color.White,
    override val outline: Color = Color.White,
    override val outlineVariant: Color = Color.White,
    override val scrim: Color = Color.White,
) : DefaultColors {

    override val material = ColorScheme(
        primary = primary,
        onPrimary = onPrimary,
        primaryContainer = primaryContainer,
        onPrimaryContainer = onPrimaryContainer,
        inversePrimary = inversePrimary,
        secondary = secondary,
        onSecondary = onSecondary,
        secondaryContainer = secondaryContainer,
        onSecondaryContainer = onSecondaryContainer,
        tertiary = tertiary,
        onTertiary = onTertiary,
        tertiaryContainer = tertiaryContainer,
        onTertiaryContainer = onTertiaryContainer,
        background = background,
        onBackground = onBackground,
        surface = surface,
        onSurface = onSurface,
        surfaceVariant = surfaceVariant,
        onSurfaceVariant = onSurfaceVariant,
        surfaceTint = surfaceTint,
        inverseSurface = inverseSurface,
        inverseOnSurface = inverseOnSurface,
        error = error,
        onError = onError,
        errorContainer = errorContainer,
        onErrorContainer = onError,
        outline = outline,
        outlineVariant = outlineVariant,
        scrim = scrim,
    )
}

val LocalColors = staticCompositionLocalOf<DefaultColors> {
    LightColors()
}
