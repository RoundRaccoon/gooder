package com.danielnastase.gooder.presentation.clients.register

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.GooderRoutes
import com.danielnastase.gooder.presentation.clients.register.RegisterEvent
import com.danielnastase.gooder.presentation.clients.register.RegisterViewModel
import com.danielnastase.gooder.presentation.clients.register.areFieldsFilled
import com.danielnastase.gooder.ui.components.GooderButton
import com.danielnastase.gooder.ui.components.GooderTextField
import com.danielnastase.gooder.ui.components.GooderTopAppBar
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RegisterScreen(
    appState: GooderAppState,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val context = LocalContext.current
    val showLoadingDialog = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            showLoadingDialog.value = false
            when (event) {
                is RegisterViewModel.UiEvent.RegisterSuccessful -> {
                    appState.navigateAndClear(GooderRoutes.DiscoverScreen.route)
                }
                is RegisterViewModel.UiEvent.RegisterUnsuccessful -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    if (true) {
        Dialog(onDismissRequest = { }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(160.dp)
                    .background(Color.White)
                    .clip(RoundedCornerShape(15.dp))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize().padding(20.dp)
                ) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    Text(text = "Setting up your account...")
                }
            }
        }
    }

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
                title = "Create new account",
                onBackClicked = { appState.popUp() }
            )
            Spacer(Modifier.height(56.dp))
            GooderTextField(
                value = state.username,
                onValueChange = { viewModel.onEvent(RegisterEvent.EnteredUsername(it)) },
                title = "Username",
                placeholder = "What is your username?")
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = state.email,
                onValueChange = { viewModel.onEvent(RegisterEvent.EnteredEmail(it)) },
                title = "Email",
                placeholder = "What is your email?")
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = state.password,
                onValueChange = { viewModel.onEvent(RegisterEvent.EnteredPassword(it)) },
                title = "Password",
                placeholder = "Type password" ,
                isPassword = true
            )
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = state.confirmPassword,
                onValueChange = { viewModel.onEvent(RegisterEvent.EnteredConfirmPassword(it)) },
                title = "Confirm Password",
                placeholder = "Type password again",
                isPassword = true
            )
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                GooderButton(
                    onClick = {
                        showLoadingDialog.value = true
                        viewModel.onEvent(RegisterEvent.RegisterAccount)
                    },
                    label = "Proceed",
                    labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24,
                    color = if (state.areFieldsFilled()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}