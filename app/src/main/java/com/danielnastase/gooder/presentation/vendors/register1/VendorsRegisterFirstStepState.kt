package com.danielnastase.gooder.presentation.vendors.register1

data class VendorsRegisterFirstStepState (
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)

fun VendorsRegisterFirstStepState.areFieldsFilled(): Boolean {
    return email.isNotEmpty() &&
            password.isNotEmpty() &&
            confirmPassword.isNotEmpty()
}