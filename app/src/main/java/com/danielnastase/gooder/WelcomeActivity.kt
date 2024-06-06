package com.danielnastase.gooder

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.danielnastase.gooder.ui.components.WelcomeScreen
import com.danielnastase.gooder.ui.theme.EerieBlack

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen(
                appName = "gooder",
                logoPainter = painterResource(id = R.drawable.gooder_logo),
                firstOptionLabel = "Register",
                firstOptionOnClick = { startRegisterActivity() },
                secondOptionLabel = "Login",
                secondOptionOnClick = { startLoginActivity() }
            )
        }
    }
    private fun startRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun startLoginActivity() {
//        val intent = Intent(this, ::class.java)
//        startActivity(intent)
    }
}

