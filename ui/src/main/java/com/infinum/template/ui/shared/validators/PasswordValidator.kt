package com.infinum.template.ui.shared.validators

private const val MINIMUM_PASSWORD_LENGTH = 5

val passwordValidator = object : Validator<String> {

    override fun isValid(input: String): Boolean = input.length >= MINIMUM_PASSWORD_LENGTH
}
