package com.danielnastase.gooder.presentation.clients.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
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
class RegisterViewModel @Inject constructor(
    private val authService: AuthService,
    private val databaseService: DatabaseService
) : ViewModel() {
    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.EnteredUsername -> {
                _state.value = state.value.copy(
                    username = event.value
                )
            }
            is RegisterEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is RegisterEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            is RegisterEvent.EnteredConfirmPassword -> {
                _state.value = state.value.copy(
                    confirmPassword = event.value
                )
            }
            is RegisterEvent.RegisterAccount -> {
                if (!_state.value.areFieldsFilled()) {
                    // Button is grayed out
                    return
                }

                viewModelScope.launch {
                    try {
                        if (!validateInputs()) {
                            return@launch
                        }
                        createAccount()
                    } catch (e: Exception) {
                        _eventFlow.emit(
                            UiEvent.RegisterUnsuccessful(
                                e.localizedMessage ?: "Error at account creation"
                            )
                        )
                    }

                }
            }
        }
    }

    private suspend fun validateInputs(): Boolean {
        if (_state.value.password != _state.value.confirmPassword) {
            _eventFlow.emit(UiEvent.RegisterUnsuccessful("Passwords do not match"))
            return false
        }

        if (!_state.value.email.contains('@')) {
            _eventFlow.emit(UiEvent.RegisterUnsuccessful("Email is not valid"))
            return false
        }

        return true
    }

    private suspend fun createAccount() {
        authService.createUser(_state.value.email, _state.value.password)
        databaseService.createUser(_state.value.email, _state.value.username)
        _eventFlow.emit(UiEvent.RegisterSuccessful)
    }

    sealed class UiEvent{
        data class RegisterUnsuccessful(val message: String): UiEvent()
        object RegisterSuccessful : UiEvent()
    }
}