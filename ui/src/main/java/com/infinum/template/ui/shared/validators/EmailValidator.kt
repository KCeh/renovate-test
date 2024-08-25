package com.infinum.template.ui.shared.validators

import android.util.Patterns

val emailValidator = object : Validator<String> {

    override fun isValid(input: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(input).matches()
}
