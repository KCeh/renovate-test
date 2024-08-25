package com.infinum.template.backend.bridge.mappers

import com.infinum.template.backend.data.models.AuthorizationResponse
import com.infinum.template.models.AccessData
import com.infinum.template.models.AccessUser
import com.infinum.template.models.User

internal fun AuthorizationResponse.toDomain() = AccessUser(
    accessData = AccessData(
        token = accessToken,
        client = client,
        uid = uid,
    ),
    user = response.user.run {
        User(
            id = id,
            email = email,
            imageUrl = imageUrl,
        )
    },
)
