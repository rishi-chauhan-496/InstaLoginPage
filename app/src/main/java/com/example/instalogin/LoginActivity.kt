package com.example.instalogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.instalogin.ui.theme.InstaLoginTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instalogin.loginAppScreens.CreateNewAccount1
import com.example.instalogin.loginAppScreens.CreateNewAccount2
import com.example.instalogin.loginAppScreens.ForgottenPasswordPage1
import com.example.instalogin.loginAppScreens.ForgottenPasswordPage2
import com.example.instalogin.loginAppScreens.InstaLogin


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaLoginTheme {
                val navController = rememberNavController()
                MyAppNavHost(navController)
            }
        }
    }
}

@Composable
fun MyAppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route // Set the starting screen
    ) {
        composable(route = Screen.Home.route) {
            // Define the UI for the home screen
            InstaLogin(
                onForgotPasswordClick = {
                    navController.navigate(Screen.ForgottenPassword1.route)
                },
                onCreateAcButtonClick = {
                    navController.navigate(Screen.CreateNewAccount1.route)
                }
            )
        }
        composable(route = Screen.ForgottenPassword1.route) {
            // Define the UI for the detail screen
            ForgottenPasswordPage1(
                onNavigateBack = {
                    navController.navigate(Screen.Home.route) // Or navController.navigateUp()
                },
                onSearchClick = {
                    navController.navigate(Screen.ForgottenPassword2.route)
                }
            )
        }
        composable(route = Screen.ForgottenPassword2.route) {
            // Define the UI for the detail screen
            ForgottenPasswordPage2(
                onNavigateBack = {
                    navController.navigate(Screen.Home.route) // Or navController.navigateUp()
                },
                onSearchClick = {
                    navController.navigate(Screen.ForgottenPassword1.route)
                }
            )
        }
        composable(route = Screen.CreateNewAccount1.route) {
            // Define the UI for the detail screen
            CreateNewAccount1(
                onNavigateBack = {
                    navController.navigate(Screen.Home.route) // Or navController.navigateUp()
                },
                onButtonClick = {
                    navController.navigate(Screen.CreateNewAccount2.route)
                }
            )
        }
        composable(route = Screen.CreateNewAccount2.route) {
            // Define the UI for the detail screen
            CreateNewAccount2(
                onNavigateBack = {
                    navController.navigate(Screen.Home.route) // Or navController.navigateUp()
                },
                onButtonClick = {
                    navController.navigate(Screen.CreateNewAccount1.route)
                }
            )
        }
    }
}


@Preview
@Composable
fun InstaLoginPreview() {
//    InstaLogin(onForgotPasswordClick = {},onCreateAcButtonClick = {})
//    ForgottenPasswordPage1(onNavigateBack = {}, onSearchClick = {})
//    ForgottenPasswordPage2(onNavigateBack = {}, onSearchClick = {})
//    CreateNewAccount1(onNavigateBack = {}, onButtonClick = {})
//    CreateNewAccount2(onNavigateBack = {}, onButtonClick = {})

}
