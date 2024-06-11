package com.danielnastase.gooder.presentation.vendors.register2

import android.net.Uri

sealed class VendorsRegisterSecondStepEvent {
    data class EnteredName(val value: String): VendorsRegisterSecondStepEvent()
    data class ResultLogo(val uri: Uri?): VendorsRegisterSecondStepEvent()
    data class ResultBanner(val uri: Uri?): VendorsRegisterSecondStepEvent()
    object PressedProceed: VendorsRegisterSecondStepEvent()
}