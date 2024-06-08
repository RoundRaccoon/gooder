package com.danielnastase.gooder

import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController

@Stable
class GooderAppState(val navController: NavHostController) {
    fun navigate(route: String) {
        navController.navigate(route) { launchSingleTop = true }
    }
}