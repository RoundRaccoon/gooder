package com.danielnastase.gooder

sealed class GooderRoutes(val route: String) {
    object WelcomeScreen: GooderRoutes("welcome_screen")
    object LoginScreen: GooderRoutes("login_screen")
    object RegisterScreen: GooderRoutes("register_screen")
    object DiscoverScreen: GooderRoutes("discover_screen")
}