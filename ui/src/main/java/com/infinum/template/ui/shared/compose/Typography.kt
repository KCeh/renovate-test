package com.infinum.template.ui.shared.compose

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Typography as MaterialTypography

private val defaultTypography = MaterialTypography()

interface DefaultTypography {
    val displayLarge: TextStyle
    val displayMedium: TextStyle
    val displaySmall: TextStyle
    val headlineLarge: TextStyle
    val headlineMedium: TextStyle
    val headlineSmall: TextStyle
    val titleLarge: TextStyle
    val titleMedium: TextStyle
    val titleSmall: TextStyle
    val bodyLarge: TextStyle
    val bodyMedium: TextStyle
    val bodySmall: TextStyle
    val labelLarge: TextStyle
    val labelMedium: TextStyle
    val labelSmall: TextStyle
    val material: MaterialTypography
}

data class Typography(
    override val displayLarge: TextStyle = defaultTypography.displayLarge,
    override val displayMedium: TextStyle = defaultTypography.displayMedium,
    override val displaySmall: TextStyle = defaultTypography.displaySmall,
    override val headlineLarge: TextStyle = defaultTypography.headlineLarge,
    override val headlineMedium: TextStyle = defaultTypography.headlineMedium,
    override val headlineSmall: TextStyle = defaultTypography.headlineSmall,
    override val titleLarge: TextStyle = defaultTypography.titleLarge,
    override val titleMedium: TextStyle = defaultTypography.titleMedium,
    override val titleSmall: TextStyle = defaultTypography.titleSmall,
    override val bodyLarge: TextStyle = defaultTypography.bodyLarge,
    override val bodyMedium: TextStyle = defaultTypography.bodyMedium,
    override val bodySmall: TextStyle = defaultTypography.bodySmall,
    override val labelLarge: TextStyle = defaultTypography.labelLarge,
    override val labelMedium: TextStyle = defaultTypography.labelMedium,
    override val labelSmall: TextStyle = defaultTypography.labelSmall,
) : DefaultTypography {

    override val material = MaterialTypography(
        displayLarge = displayLarge,
        displayMedium = displayMedium,
        displaySmall = displaySmall,
        headlineLarge = headlineLarge,
        headlineMedium = headlineMedium,
        headlineSmall = headlineSmall,
        titleLarge = titleLarge,
        titleMedium = titleMedium,
        titleSmall = titleSmall,
        bodyLarge = bodyLarge,
        bodyMedium = bodyMedium,
        bodySmall = bodySmall,
        labelLarge = labelLarge,
        labelMedium = labelMedium,
        labelSmall = labelSmall,
    )
}

val LocalTypography = staticCompositionLocalOf<DefaultTypography> {
    Typography()
}
