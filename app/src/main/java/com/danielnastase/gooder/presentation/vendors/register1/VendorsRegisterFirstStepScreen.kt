package com.danielnastase.gooder.presentation.vendors.register1

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.ui.components.GooderButton
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
    val state = viewModel.state.value
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is VendorsRegisterFirstStepViewModel.UiEvent.CredentialsAccepted -> {
                    TODO("Navigate to next screen")
                }
                is VendorsRegisterFirstStepViewModel.UiEvent.CredentialsDenied -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
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
                title = "Register vendor account",
                onBackClicked = { appState.popUp() }
            )
            Spacer(Modifier.height(56.dp))
            GooderTextField(
                value = state.email,
                onValueChange = { viewModel.onEvent(VendorsRegisterFirstStepEvent.EnteredEmail(it)) },
                title = "Email",
                placeholder = "What is your email?")
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = state.password,
                onValueChange = { viewModel.onEvent(VendorsRegisterFirstStepEvent.EnteredPassword(it)) },
                title = "Password",
                placeholder = "Type password" ,
                isPassword = true
            )
            Spacer(Modifier.height(16.dp))
            GooderTextField(
                value = state.confirmPassword,
                onValueChange = { viewModel.onEvent(VendorsRegisterFirstStepEvent.EnteredConfirmPassword(it)) },
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
                    onClick = { viewModel.onEvent(VendorsRegisterFirstStepEvent.PressedProceed) },
                    label = "Proceed",
                    labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24,
                    color = if (state.areFieldsFilled()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}