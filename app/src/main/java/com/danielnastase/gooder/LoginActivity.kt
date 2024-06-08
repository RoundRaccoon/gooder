package com.danielnastase.gooder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.danielnastase.gooder.presentation.LoginScreen

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
//        Firebase.auth.signInWithEmailAndPassword(email, password)
    }
}