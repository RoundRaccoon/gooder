package com.danielnastase.gooder.presentation.clients.profile

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.GooderRoutes
import com.danielnastase.gooder.ui.components.GooderButton
import com.danielnastase.gooder.ui.components.GooderLoadingDialog
import kotlinx.coroutines.flow.collectLatest

@Composable
fun ProfileScreen(
    homeState: GooderAppState,
    appState: GooderAppState,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val showLoadingDialog = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest { event ->
            showLoadingDialog.value = false
            when (event) {
                is ProfileViewModel.UiEvent.SignOutSuccessful -> {
                    appState.navigateAndClear(GooderRoutes.WelcomeScreen.route)
                }
                is ProfileViewModel.UiEvent.SignOutFailed -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    GooderLoadingDialog(showLoadingDialog)

    GooderButton(
        onClick = {
            showLoadingDialog.value = true
            viewModel.onEvent(ProfileEvent.SignOut) },
        label = "Sign out"
    )
}