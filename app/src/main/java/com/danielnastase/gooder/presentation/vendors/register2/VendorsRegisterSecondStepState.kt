package com.danielnastase.gooder.presentation.vendors.register2

import android.net.Uri

data class VendorsRegisterSecondStepState(
    val name: String = "",
    val logo: Uri? = null,
    val banner: Uri? = null
)