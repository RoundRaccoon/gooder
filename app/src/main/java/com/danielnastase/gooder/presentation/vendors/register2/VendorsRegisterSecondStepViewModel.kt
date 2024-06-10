package com.danielnastase.gooder.presentation.vendors.register2

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.danielnastase.gooder.GooderRoutes
import com.danielnastase.gooder.model.service.DatabaseService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class VendorsRegisterSecondStepViewModel @Inject constructor(
    private val databaseService: DatabaseService,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(VendorsRegisterSecondStepState())
    val state: State<VendorsRegisterSecondStepState> = _state

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<String>(GooderRoutes.VENDORS_REGISTER_SECOND_STEP_ARG_EMAIL)?.let { email ->
            Log.i("previous_email", email)
        }
    }

    fun onEvent(event: VendorsRegisterSecondStepEvent) {
        when (event) {
            is VendorsRegisterSecondStepEvent.EnteredName -> {
                _state.value = state.value.copy(
                    name = event.value
                )
            }
            is VendorsRegisterSecondStepEvent.UploadLogo -> {

            }
            is VendorsRegisterSecondStepEvent.UploadBanner -> {

            }
            is VendorsRegisterSecondStepEvent.PressedProceed -> {
//                if (_state.value.name.isEmpty()) {
//                    // Button is grayed out
//                    return
//                }
            }
        }
    }

    sealed class UiEvent {
        data class DetailsDenied(val message: String): UiEvent()
        object DetailsAccepted : UiEvent()
    }
}