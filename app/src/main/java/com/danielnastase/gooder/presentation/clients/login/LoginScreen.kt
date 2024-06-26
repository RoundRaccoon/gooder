package com.danielnastase.gooder.presentation.clients.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.GooderRoutes
import com.danielnastase.gooder.presentation.clients.login.LoginEvent
import com.danielnastase.gooder.presentation.clients.login.LoginViewModel
import com.danielnastase.gooder.presentation.clients.login.areFieldsFilled
import com.danielnastase.gooder.presentation.clients.register.areFieldsFilled
import com.danielnastase.gooder.ui.components.GooderButton
import com.danielnastase.gooder.ui.components.GooderLoadingDialog
import com.danielnastase.gooder.ui.components.GooderTextField
import com.danielnastase.gooder.ui.components.GooderTopAppBar
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    appState: GooderAppState,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val showLoadingDialog = remember { mutableStateOf(false) }
    val loginUnsuccessfulMessage = remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            showLoadingDialog.value = false
            when (event) {
                is LoginViewModel.UiEvent.LoginSuccessful -> {
                    appState.navigateAndClear(GooderRoutes.DiscoverScreen.route)
                }
                is LoginViewModel.UiEvent.LoginUnsuccessful -> {
                    loginUnsuccessfulMessage.value = event.message
                }
            }
        }
    }

    GooderLoadingDialog(showLoadingDialog)

    GooderTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 24.dp)
        ) {
            GooderTopAppBar(
                title = "Log into account",
                onBackClicked = { appState.popUp() }
            )
            Spacer(Modifier.height(56.dp))
            GooderTextField(
                value = state.email,
                onValueChange = { viewModel.onEvent(LoginEvent.EnteredEmail(it)) },
                title = "Email",
                placeholder = "What is your email?")
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = state.password,
                onValueChange = { viewModel.onEvent(LoginEvent.EnteredPassword(it)) },
                title = "Password",
                placeholder = "Type password",
                isPassword = true
            )
            Spacer(Modifier.height(16.dp))
            if (loginUnsuccessfulMessage.value.isNotEmpty()) {
                Text(
                    loginUnsuccessfulMessage.value,
                    color = Color.Red,
                    style = MaterialTheme.gooderTypography.semi_bold_16_24
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                GooderButton(
                    onClick = {
                        showLoadingDialog.value = true
                        viewModel.onEvent(LoginEvent.LoginAccount)
                              },
                    label = "Proceed",
                    labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24,
                    color = if (state.areFieldsFilled()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}