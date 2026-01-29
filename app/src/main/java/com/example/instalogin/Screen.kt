package com.example.instalogin

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object ForgottenPassword1 : Screen("forgotten_password_screen_1")
    object ForgottenPassword2 : Screen("forgotten_password_screen_2")
    object CreateNewAccount1 : Screen("create_new_account_screen_1")
    object CreateNewAccount2 : Screen("create_new_account_screen_2")
}

