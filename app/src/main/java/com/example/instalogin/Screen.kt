package com.example.instalogin

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object ForgottenPassword : Screen("forgotten_password_screen")
}
