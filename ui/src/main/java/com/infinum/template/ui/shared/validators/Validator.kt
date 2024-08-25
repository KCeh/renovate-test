package com.infinum.template.ui.shared.validators

interface Validator<T> {

    fun isValid(input: T): Boolean
}
