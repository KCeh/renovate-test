package com.infinum.template.ui.shared.compose

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.material3.Shapes as MaterialShapes

interface DefaultShapes {
    val extraSmall: CornerBasedShape
    val small: CornerBasedShape
    val medium: CornerBasedShape
    val large: CornerBasedShape
    val extraLarge: CornerBasedShape
    val material: MaterialShapes
}

data class Shapes(
    override val extraSmall: CornerBasedShape = ShapeDefaults.ExtraSmall,
    override val small: CornerBasedShape = ShapeDefaults.Small,
    override val medium: CornerBasedShape = ShapeDefaults.Medium,
    override val large: CornerBasedShape = ShapeDefaults.Large,
    override val extraLarge: CornerBasedShape = ShapeDefaults.ExtraLarge,
) : DefaultShapes {

    override val material = MaterialShapes(
        extraSmall = extraSmall,
        small = small,
        medium = medium,
        large = large,
        extraLarge = extraLarge,
    )
}

val LocalShapes = staticCompositionLocalOf<DefaultShapes> {
    Shapes()
}
