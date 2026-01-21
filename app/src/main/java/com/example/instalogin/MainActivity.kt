package com.example.instalogin

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.instalogin.ui.theme.InstaLoginTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton


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
                    navController.navigate(Screen.ForgottenPassword.route)
                }
            )
        }
        composable(route = Screen.ForgottenPassword.route) {
            // Define the UI for the detail screen
            ForgottenPasswordPage(
                onNavigateBack = {
                    navController.popBackStack() // Or navController.navigateUp()
                }
            )
        }
    }
}

@Composable
fun InstaLogin(
    onForgotPasswordClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        //language SelectionList
        Text(
            text = stringResource(R.string.language_english_india),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(100.dp))

        //Insta Logo
        Image(
            painter = painterResource(id = R.drawable.instagram),
            contentDescription = stringResource(R.string.instagram_logo),
            modifier = Modifier
                .size(60.dp)
                .border(
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.background),
                    shape = RoundedCornerShape(12.dp)
                )
        )

        Spacer(modifier = Modifier.height(100.dp))

        //TextField for Username, email address or mobile number
        var username by remember { mutableStateOf("") }

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = {
                Text(stringResource(R.string.username_hint))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(10.dp)
        )


        Spacer(modifier = Modifier.height(12.dp))

        //TextField for Password
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text(stringResource(R.string.password_hint))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        //Login Button
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text = stringResource(R.string.login))

        }

        Spacer(modifier = Modifier.height(16.dp))

        //Clickable Text For Forgotten Password
//        val context = LocalContext.current
        Text(
            text = stringResource(R.string.forgotten_password),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp,
            modifier = Modifier.clickable {
//                val intent = Intent(context, MainActivity2::class.java)
//                context.startActivity(intent)
                onForgotPasswordClick()
            }
        )

        Spacer(modifier = Modifier.height(150.dp))

        //Button Create new Account
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp,MaterialTheme.colorScheme.primary),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background
            )
        ) {
            Text(
                text = stringResource(R.string.create_new_account),
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        //Meta Logo Or Text
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.meta),
                contentDescription = stringResource(R.string.meta_logo),
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = stringResource(R.string.meta),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun ForgottenPasswordPage(
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        // Back button
        BackArrow {
            onNavigateBack()
        }


        Spacer(modifier = Modifier.height(24.dp))

        //Text
        Text(
            text = stringResource(R.string.find_account),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.enter_email_or_username),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp
        )

        Text(
            text = stringResource(R.string.cant_reset_password),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 14.sp,
            modifier = Modifier.clickable {
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // LoginInfo TextFiled
        var loginInfo by remember { mutableStateOf("") }


        OutlinedTextField(
            value = loginInfo,
            onValueChange = { loginInfo = it },
            placeholder = {
                Text(stringResource(R.string.email_or_username_hint))
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(10.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = stringResource(R.string.security_note),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Continue button
        Button(
            onClick = {
                // handle continue
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = stringResource(R.string.continue_),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.search_by_mobile),
            color = Color(0xFF1B74E4),
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {}
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.or_divider),
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Facebook login
        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.facebook),
                contentDescription = "Facebook",
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.login_with_facebook))
        }
    }
}

@Composable
fun BackArrow(onBack: () -> Unit) {
    IconButton(
        onClick = onBack,
        modifier = Modifier.size(40.dp) // touch target
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun InstaLoginPreview() {
    InstaLogin(onForgotPasswordClick = {})
//    ForgottenPasswordPage(onNavigateBack = {})
}
