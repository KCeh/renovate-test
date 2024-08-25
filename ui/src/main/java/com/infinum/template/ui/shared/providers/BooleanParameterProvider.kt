package com.infinum.template.ui.shared.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class BooleanParameterProvider : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean> = sequenceOf(true, false)
}
