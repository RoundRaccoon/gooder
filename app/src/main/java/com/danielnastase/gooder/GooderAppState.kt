package com.danielnastase.gooder

import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController

@Stable
class GooderAppState(val navController: NavHostController) {
    fun navigate(route: String) {
        navController.navigate(route) { launchSingleTop = true }
    }

    fun popUp() {
        navController.popBackStack()
    }

    fun navigateAndPopUp(route: String, popUp: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(popUp) { inclusive = true }
        }
    }

    fun navigateAndClear(route: String) {
        navController.navigate(route) {
            launchSingleTop = true
            popUpTo(0) { inclusive = true }
        }
    }
}