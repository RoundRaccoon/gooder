package com.danielnastase.gooder.presentation.vendors.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielnastase.gooder.model.service.AuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VendorsWelcomeViewModel @Inject constructor(
    private val authService: AuthService
) : ViewModel() {
    private val _eventFlow = MutableSharedFlow<AuthEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onAppStart() {
        if (!authService.hasUser()) {
            return
        }

        viewModelScope.launch {
            _eventFlow.emit(AuthEvent.SkipAuth)
        }
    }

    sealed class AuthEvent {
        object SkipAuth : AuthEvent()
    }
}