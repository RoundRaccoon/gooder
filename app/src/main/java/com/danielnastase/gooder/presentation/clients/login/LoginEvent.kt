package com.danielnastase.gooder.presentation.clients.login

sealed class LoginEvent {
    data class EnteredEmail(val value: String): LoginEvent()
    data class EnteredPassword(val value: String): LoginEvent()
    object LoginAccount: LoginEvent()
}