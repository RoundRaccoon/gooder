package com.danielnastase.gooder.model

data class User(
    val email: String = "",
    val username: String = "",
    val isVendor: Boolean = false
)