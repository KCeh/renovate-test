package com.infinum.template.backend.data.internal.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TermsAndConditionsRequest(
    @SerialName(value = "hasAccepted") val hasAccepted: Boolean,
)
