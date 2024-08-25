package com.infinum.template.preferences.bridge.mapping

import com.infinum.template.models.AccessData
import com.infinum.template.preferences.data.models.AuthData
import com.infinum.template.models.AuthData as DomainAuthData

internal fun authToSource(accessData: AccessData, autoLogin: Boolean) = AuthData(
    token = accessData.token,
    client = accessData.client,
    uid = accessData.uid,
    autoLogin = autoLogin,
)

internal fun AuthData.toDomain(): DomainAuthData = DomainAuthData(
    accessData = AccessData(token = token, client = client, uid = uid),
    autoLogin = autoLogin,
)
