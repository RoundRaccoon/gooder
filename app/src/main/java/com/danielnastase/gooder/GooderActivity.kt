package com.danielnastase.gooder

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.painterResource
import com.danielnastase.gooder.ui.components.WelcomeScreen
import com.danielnastase.gooder.ui.screens.GooderApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GooderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = getColor(R.color.black)

        setContent { GooderApp() }
    }

//    WelcomeScreen(
//    appName = "gooder",
//    logoPainter = painterResource(id = R.drawable.gooder_logo),
//    firstOptionLabel = "Register",
//    firstOptionOnClick = { startRegisterActivity() },
//    secondOptionLabel = "Login",
//    secondOptionOnClick = { startLoginActivity() }
//    )
//
//    private fun startRegisterActivity() {
//        val intent = Intent(this, RegisterActivity::class.java)
//        startActivity(intent)
//    }
//
//    private fun startLoginActivity() {
//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)
//    }
}

