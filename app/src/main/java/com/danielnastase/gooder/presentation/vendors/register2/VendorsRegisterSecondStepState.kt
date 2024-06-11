package com.danielnastase.gooder.presentation.vendors.register2

import android.net.Uri

data class VendorsRegisterSecondStepState(
    val name: String = "",
    val logoUri: Uri? = null,
    val bannerUri: Uri? = null
)