package com.danielnastase.gooder.presentation.vendors.register1

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.GooderRoutes
import com.danielnastase.gooder.ui.components.GooderButton
import com.danielnastase.gooder.ui.components.GooderLoadingDialog
import com.danielnastase.gooder.ui.components.GooderTextField
import com.danielnastase.gooder.ui.components.GooderTopAppBar
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography
import kotlinx.coroutines.flow.collectLatest

@Composable
fun VendorsRegisterFirstStepScreen(
    appState: GooderAppState,
    viewModel: VendorsRegisterFirstStepViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val showLoadingDialog = remember { mutableStateOf(false) }
    val credentialsDeniedMessage = remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            showLoadingDialog.value = false
            when (event) {
                is VendorsRegisterFirstStepViewModel.UiEvent.CredentialsAccepted -> {
                    appState.navigate(
                        GooderRoutes.VendorsRegisterSecondStepScreen.route +
                                "/${state.value.email}" +
                                "/${state.value.password}"
                    )
                }
                is VendorsRegisterFirstStepViewModel.UiEvent.CredentialsDenied -> {
                    credentialsDeniedMessage.value = event.message
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
                title = "Register vendor account",
                onBackClicked = { appState.popUp() }
            )
            Spacer(Modifier.height(56.dp))
            GooderTextField(
                value = state.value.email,
                onValueChange = { viewModel.onEvent(VendorsRegisterFirstStepEvent.EnteredEmail(it)) },
                title = "Email",
                placeholder = "What is your email?")
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = state.value.password,
                onValueChange = { viewModel.onEvent(VendorsRegisterFirstStepEvent.EnteredPassword(it)) },
                title = "Password",
                placeholder = "Type password" ,
                isPassword = true
            )
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = state.value.confirmPassword,
                onValueChange = { viewModel.onEvent(VendorsRegisterFirstStepEvent.EnteredConfirmPassword(it)) },
                title = "Confirm Password",
                placeholder = "Type password again",
                isPassword = true
            )
            Spacer(Modifier.height(16.dp))
            if (credentialsDeniedMessage.value.isNotEmpty()) {
                Text(
                    credentialsDeniedMessage.value,
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
                        viewModel.onEvent(VendorsRegisterFirstStepEvent.PressedProceed) },
                    label = "Proceed",
                    labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24,
                    color = if (state.value.areFieldsFilled()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}