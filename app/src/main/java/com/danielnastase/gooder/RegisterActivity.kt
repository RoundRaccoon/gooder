package com.danielnastase.gooder

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danielnastase.gooder.ui.screens.RegisterScreen
import com.danielnastase.gooder.ui.theme.GooderTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.black)

        setContent {
            RegisterScreen (
                createAccount = { username, email, password, confirmPassword ->
                    createAccount(username, email, password, confirmPassword)
                }
            )
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