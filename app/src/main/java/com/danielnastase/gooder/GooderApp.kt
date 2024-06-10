package com.danielnastase.gooder.ui.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.GooderRoutes
import com.danielnastase.gooder.presentation.clients.HomeScreen
import com.danielnastase.gooder.presentation.clients.login.LoginScreen
import com.danielnastase.gooder.presentation.clients.register.RegisterScreen
import com.danielnastase.gooder.presentation.vendors.register1.VendorsRegisterFirstStepScreen
import com.danielnastase.gooder.presentation.vendors.register2.VendorsRegisterSecondStepScreen
import com.danielnastase.gooder.presentation.vendors.welcome.VendorsWelcomeScreen
import com.danielnastase.gooder.ui.components.WelcomeScreen
import com.danielnastase.gooder.ui.theme.GooderTheme

@Composable
fun GooderApp() {
    GooderTheme {
        val appState = rememberAppState()

        NavHost(
            navController = appState.navController,
            startDestination = GooderRoutes.VendorsWelcomeScreen.route,
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
        WelcomeScreen(appState)
    }
    composable(GooderRoutes.RegisterScreen.route) {
        RegisterScreen(appState)
    }
    composable(GooderRoutes.LoginScreen.route) {
        LoginScreen(appState)
    }
    composable(GooderRoutes.DiscoverScreen.route) {
        HomeScreen(appState)
    }
    composable(GooderRoutes.VendorsWelcomeScreen.route) {
        VendorsWelcomeScreen(appState)
    }
    composable(
        GooderRoutes.VendorsRegisterFirstStepScreen.route
    ) {
        VendorsRegisterFirstStepScreen(appState)
    }
    composable(
        route = GooderRoutes.VendorsRegisterSecondStepScreen.route +
                GooderRoutes.VENDORS_REGISTER_SECOND_STEP_ARGS,
        arguments = listOf(
            navArgument(GooderRoutes.VENDORS_REGISTER_SECOND_STEP_ARG_EMAIL) {
                type = NavType.StringType
            },
            navArgument(GooderRoutes.VENDORS_REGISTER_SECOND_STEP_ARG_PASSWORD) {
                type = NavType.StringType
            }
        )
    ) {
        VendorsRegisterSecondStepScreen(appState)
    }
}