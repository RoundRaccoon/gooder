package com.danielnastase.gooder.presentation.clients.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielnastase.gooder.model.service.AuthService
import com.google.firebase.FirebaseException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authService: AuthService
) : ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is LoginEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            is LoginEvent.LoginAccount -> {
                if (!_state.value.areFieldsFilled()) {
                    // Button is grayed out
                    return
                }

                viewModelScope.launch {
                    try {
                        if (!validateInputs()) {
                            return@launch
                        }
                        authService.signIn(_state.value.email, _state.value.password)
                        _eventFlow.emit(UiEvent.LoginSuccessful)
                    } catch (e: Exception) {
                        _eventFlow.emit(
                            UiEvent.LoginUnsuccessful(
                                e.localizedMessage ?: "Error at authentication"
                            )
                        )
                    }
                }
            }
        }
    }

    private suspend fun validateInputs(): Boolean{
        if (!_state.value.email.contains('@')) {
            _eventFlow.emit(UiEvent.LoginUnsuccessful("Email is not valid"))
            return false
        }

        return true
    }

    sealed class UiEvent{
        data class LoginUnsuccessful(val message: String): UiEvent()
        object LoginSuccessful : UiEvent()
    }
}