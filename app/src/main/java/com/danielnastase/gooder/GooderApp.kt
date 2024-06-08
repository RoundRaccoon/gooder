package com.danielnastase.gooder.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.ui.theme.GooderTheme

@Composable
fun GooderApp() {
    GooderTheme {
        val appState = rememberAppState()
//        NavHost(
//            navController = appState.navController,
//        ) {
//
//        }
    }
}

@Composable
fun rememberAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        GooderAppState(navController)
    }
