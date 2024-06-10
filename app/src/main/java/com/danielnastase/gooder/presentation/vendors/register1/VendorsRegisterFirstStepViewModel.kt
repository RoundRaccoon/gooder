package com.danielnastase.gooder.presentation.vendors.register1

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
class VendorsRegisterFirstStepViewModel @Inject constructor(
    private val databaseService: DatabaseService
) : ViewModel() {
    private val _state = mutableStateOf(VendorsRegisterFirstStepState())
    val state: State<VendorsRegisterFirstStepState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: VendorsRegisterFirstStepEvent) {
        when (event) {
            is VendorsRegisterFirstStepEvent.EnteredEmail -> {
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is VendorsRegisterFirstStepEvent.EnteredPassword -> {
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            is VendorsRegisterFirstStepEvent.EnteredConfirmPassword -> {
                _state.value = state.value.copy(
                    confirmPassword = event.value
                )
            }
            is VendorsRegisterFirstStepEvent.PressedProceed -> {
                if (!_state.value.areFieldsFilled()) {
                    // Button is grayed out
                    return
                }

                viewModelScope.launch {
                    try {
                        if (!validateInputs()) {
                            return@launch
                        }
                        if (!databaseService.isEmailAvailable(_state.value.email)) {
                            _eventFlow.emit(UiEvent.CredentialsDenied("Email already in use"))
                            return@launch
                        }
                        TODO("Create package to send to second step viewModel")
                        _eventFlow.emit(UiEvent.CredentialsAccepted)
                    } catch (e: Exception) {
                        _eventFlow.emit(
                            UiEvent.CredentialsDenied(
                                e.localizedMessage ?: "Unknown error occurred"
                            )
                        )
                    }
                }
            }
        }
    }

    private suspend fun validateInputs(): Boolean {
        if (_state.value.password != _state.value.confirmPassword) {
            _eventFlow.emit(UiEvent.CredentialsDenied("Passwords do not match"))
            return false
        }

        if (!_state.value.email.contains('@')) {
            _eventFlow.emit(UiEvent.CredentialsDenied("Email is not valid"))
            return false
        }

        return true
    }

    sealed class UiEvent{
        data class CredentialsDenied(val message: String): UiEvent()
        object CredentialsAccepted : UiEvent()
    }
}