package com.danielnastase.gooder.presentation.clients

sealed class HomeRoutes(val route: String) {
    object DiscoverScreen: HomeRoutes("discover_screen")
    object StoresScreen: HomeRoutes("stores_screen")
    object ProfileScreen: HomeRoutes("profile_screen")
}