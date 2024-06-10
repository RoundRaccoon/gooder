package com.danielnastase.gooder.presentation.clients.profile

sealed class ProfileEvent {
    object SignOut: ProfileEvent()
}