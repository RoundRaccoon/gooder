package com.danielnastase.gooder.ui.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.GooderRoutes
import com.danielnastase.gooder.R
import com.danielnastase.gooder.presentation.DiscoverScreen
import com.danielnastase.gooder.presentation.LoginScreen
import com.danielnastase.gooder.presentation.RegisterScreen
import com.danielnastase.gooder.ui.components.WelcomeScreen
import com.danielnastase.gooder.ui.theme.GooderTheme

@Composable
fun GooderApp() {
    GooderTheme {
        val appState = rememberAppState()

        NavHost(
            navController = appState.navController,
            startDestination = GooderRoutes.WelcomeScreen.route,
        ) {
            gooderGraph(appState)
        }
    }
}

@Composable
fun rememberAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        GooderAppState(navController)
    }

fun NavGraphBuilder.gooderGraph(appState: GooderAppState) {
    composable(GooderRoutes.WelcomeScreen.route) {
        WelcomeScreen(
            appState = appState,
            appName = "gooder",
            logoPainter = painterResource(id = R.drawable.gooder_logo),
            firstOptionLabel = "Login",
            firstOptionRoute = GooderRoutes.LoginScreen.route,
            secondOptionLabel = "Register",
            secondOptionRoute = GooderRoutes.RegisterScreen.route
        )
    }
    composable(GooderRoutes.RegisterScreen.route) {
        RegisterScreen(appState)
    }
//    composable(GooderRoutes.LoginScreen.route) {
//        LoginScreen()
//    }
    composable(GooderRoutes.DiscoverScreen.route) {
        DiscoverScreen()
    }
}