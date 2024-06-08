package com.danielnastase.gooder.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danielnastase.gooder.ui.components.GooderButton
import com.danielnastase.gooder.ui.components.GooderTextField
import com.danielnastase.gooder.ui.components.GooderTopAppBar
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography

@Composable
fun LoginScreen(
    loginAccount: (String, String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    GooderTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 24.dp)
        ) {
//            GooderTopAppBar("Log into account")
            Spacer(Modifier.height(56.dp))
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
                placeholder = "Type password",
                isPassword = true
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                GooderButton(
                    onClick = { loginAccount(email, password) },
                    label = "Proceed",
                    labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24
                )
            }
        }
    }
}