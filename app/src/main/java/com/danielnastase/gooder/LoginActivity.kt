package com.danielnastase.gooder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danielnastase.gooder.ui.screens.LoginScreen
import com.danielnastase.gooder.ui.theme.GooderTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.black)

        setContent {
            LoginScreen(
                loginAccount = { email, password ->
                    loginAccount(email, password)
                }
            )
        }
    }

    private fun loginAccount(
        email: String,
        password: String
    ) {

    }
}