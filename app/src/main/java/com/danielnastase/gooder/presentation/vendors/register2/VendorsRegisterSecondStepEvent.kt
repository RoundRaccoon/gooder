package com.danielnastase.gooder.presentation.vendors.register2

sealed class VendorsRegisterSecondStepEvent {
    data class EnteredName(val value: String): VendorsRegisterSecondStepEvent()
    object UploadLogo: VendorsRegisterSecondStepEvent()
    object UploadBanner: VendorsRegisterSecondStepEvent()
    object PressedProceed: VendorsRegisterSecondStepEvent()
}