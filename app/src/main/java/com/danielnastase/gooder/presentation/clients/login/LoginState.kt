package com.danielnastase.gooder.presentation.clients.login

data class LoginState (
    val email: String = "",
    val password: String = ""
)

fun LoginState.areFieldsFilled(): Boolean {
    return email.isNotEmpty() && password.isNotEmpty()
}