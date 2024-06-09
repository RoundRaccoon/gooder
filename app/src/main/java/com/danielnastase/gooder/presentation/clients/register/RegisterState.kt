package com.danielnastase.gooder.presentation.clients.register

data class RegisterState (
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
)

fun RegisterState.areFieldsFilled(): Boolean {
    return username.isNotEmpty() &&
            email.isNotEmpty() &&
            password.isNotEmpty() &&
            confirmPassword.isNotEmpty()
}