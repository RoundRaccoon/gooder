package com.danielnastase.gooder

sealed class GooderRoutes(val route: String) {
    object WelcomeScreen: GooderRoutes("welcome_screen")
    object LoginScreen: GooderRoutes("login_screen")
    object RegisterScreen: GooderRoutes("register_screen")
    object DiscoverScreen: GooderRoutes("discover_screen")
    object VendorsWelcomeScreen: GooderRoutes("vendors_welcome_screen")
    object VendorsLoginScreen: GooderRoutes("vendors_login_screen")
    object VendorsRegisterFirstStepScreen: GooderRoutes("vendors_register_first_step_screen")
    object VendorsRegisterSecondStepScreen: GooderRoutes("vendors_register_second_step_screen")
    object VendorsRegisterThirdStepScreen: GooderRoutes("vendors_register_third_step_screen")
}
