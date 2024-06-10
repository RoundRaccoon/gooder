package com.danielnastase.gooder.presentation.clients.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielnastase.gooder.model.service.AuthService
import com.danielnastase.gooder.model.service.DatabaseService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authService: AuthService,
    private val databaseService: DatabaseService
) : ViewModel() {
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.SignOut -> { handleSignOutEvent() }
        }
    }

    private fun handleSignOutEvent() {
        viewModelScope.launch {
            try {
                authService.signOut()
                _eventFlow.emit(UiEvent.SignOutSuccessful)
            } catch (e: Exception) {
                _eventFlow.emit(
                    UiEvent.SignOutFailed(e.message ?: "Unknown error while signing out")
                )
            }
        }
    }

    sealed class UiEvent {
        data class SignOutFailed(val message: String) : UiEvent()
        object SignOutSuccessful : UiEvent()
    }
}
