package com.example.instalogin

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object ForgottenPassword1 : Screen("forgotten_password_screen_1")
    object ForgottenPassword2 : Screen("forgotten_password_screen_2")
}

