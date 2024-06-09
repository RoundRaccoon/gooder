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
import com.danielnastase.gooder.presentation.clients.login.LoginScreen
import com.danielnastase.gooder.presentation.clients.register.RegisterScreen
import com.danielnastase.gooder.presentation.vendors.welcome.VendorsWelcomeScreen
import com.danielnastase.gooder.ui.components.WelcomeScreen
import com.danielnastase.gooder.ui.theme.GooderTheme

@Composable
fun GooderApp() {
    GooderTheme {
        val appState = rememberAppState()

        NavHost(
            navController = appState.navController,
            startDestination = GooderRoutes.WelcomeVendorsScreen.route,
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
        WelcomeScreen(appState = appState)
    }
    composable(GooderRoutes.RegisterScreen.route) {
        RegisterScreen(appState)
    }
    composable(GooderRoutes.LoginScreen.route) {
        LoginScreen(appState)
    }
    composable(GooderRoutes.DiscoverScreen.route) {
        DiscoverScreen()
    }
    composable(GooderRoutes.WelcomeVendorsScreen.route) {
        VendorsWelcomeScreen(appState = appState)
    }
}