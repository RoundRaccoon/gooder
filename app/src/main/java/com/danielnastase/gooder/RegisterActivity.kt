package com.danielnastase.gooder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.danielnastase.gooder.presentation.RegisterScreen

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.black)

        setContent {
        }
    }

    private fun createAccount(
        username: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {

    }
}