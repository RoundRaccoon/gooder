package com.danielnastase.gooder.presentation.register

sealed class RegisterEvent {
    data class EnteredUsername(val value: String): RegisterEvent()
    data class EnteredEmail(val value: String): RegisterEvent()
    data class EnteredPassword(val value: String): RegisterEvent()
    data class EnteredConfirmPassword(val value: String): RegisterEvent()
    object RegisterAccount: RegisterEvent()
}