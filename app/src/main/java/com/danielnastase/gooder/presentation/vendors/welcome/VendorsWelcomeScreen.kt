package com.danielnastase.gooder.presentation.vendors.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.GooderRoutes
import com.danielnastase.gooder.R
import com.danielnastase.gooder.ui.components.GooderButton
import com.danielnastase.gooder.ui.theme.GooderTheme
import com.danielnastase.gooder.ui.theme.gooderTypography
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

private const val WELCOME_TIMEOUT = 1L

@Composable
fun VendorsWelcomeScreen(
    appState: GooderAppState,
    viewModel: VendorsWelcomeViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        delay(WELCOME_TIMEOUT)
        viewModel.onAppStart()
    }

    LaunchedEffect(Unit) {
        viewModel.eventFlow.collectLatest {
            TODO("Add argument for navigation screen")
//            appState.navigateAndClear(GooderRoutes)
        }
    }

    GooderTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(16.dp))
            Row (
            ) {
                Text(
                    text = "Welcome to ",
                    style = MaterialTheme.gooderTypography.bold_24_32,
                    color = Color.White,
                )
                Text(
                    text = "gooder for vendors",
                    style = MaterialTheme.gooderTypography.black_24_32,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
            Spacer(Modifier.height(50.dp))
            Image(
                modifier = Modifier
                    .padding(horizontal = 5.dp),
                painter = painterResource(id = R.drawable.gooder_vendor_logo),
                contentDescription = "Gooder Logo")
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 24.dp
                    ),
                contentAlignment = Alignment.BottomStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    GooderButton(
                        onClick = { appState.navigate(GooderRoutes.RegisterScreen.route) },
                        label = "Register",
                        labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(Modifier.height(16.dp))
                    GooderButton(
                        onClick = { appState.navigate(GooderRoutes.LoginScreen.route) },
                        label = "Login",
                        labelStyle = MaterialTheme.gooderTypography.semi_bold_16_24
                    )
                }
            }
        }
    }
}