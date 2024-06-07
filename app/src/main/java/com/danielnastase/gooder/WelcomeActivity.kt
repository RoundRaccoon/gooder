package com.danielnastase.gooder

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.ui.components.OfferCard
import com.danielnastase.gooder.ui.components.WelcomeScreen
import com.danielnastase.gooder.ui.screens.DiscoverScreen
import com.danielnastase.gooder.ui.theme.EerieBlack
import com.danielnastase.gooder.ui.theme.GooderTheme

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.black)

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
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}

