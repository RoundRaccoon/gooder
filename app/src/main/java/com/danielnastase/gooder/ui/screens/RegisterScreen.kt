package com.danielnastase.gooder.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.ui.components.GooderButton
import com.danielnastase.gooder.ui.components.GooderTextField
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun RegisterScreen(
    createAccount: (String, String, String, String) -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    GooderTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 24.dp)
        ) {
            Text(
                text = "Create new account",
                style = MaterialTheme.gooderTypography.semi_bold_16_24,
                color = Color.White,
            )
            Spacer(Modifier.height(56.dp))
            GooderTextField(
                value = username,
                onValueChange = { username = it },
                title = "Username",
                placeholder = "What is your username?")
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = email,
                onValueChange = { email = it },
                title = "Email",
                placeholder = "What is your email?")
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = password,
                onValueChange = { password = it },
                title = "Password",
                placeholder = "Type password")
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                title = "Confirm Password",
                placeholder = "Type password again")
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                GooderButton(
                    onClick = { createAccount(username, email, password, confirmPassword) },
                    label = "Proceed"
                )
            }
        }
    }
}