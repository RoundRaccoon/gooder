package com.danielnastase.gooder.presentation.vendors.register1

import com.danielnastase.gooder.presentation.clients.register.RegisterEvent

sealed class VendorsRegisterFirstStepEvent {
    data class EnteredEmail(val value: String): VendorsRegisterFirstStepEvent()
    data class EnteredPassword(val value: String): VendorsRegisterFirstStepEvent()
    data class EnteredConfirmPassword(val value: String): VendorsRegisterFirstStepEvent()
    object PressedProceed: VendorsRegisterFirstStepEvent()
}