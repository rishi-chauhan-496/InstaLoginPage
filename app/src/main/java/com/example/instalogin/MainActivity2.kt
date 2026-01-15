package com.example.instalogin

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalogin.ui.theme.InstaLoginTheme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaLoginTheme {
                ForgottenPasswordPage()
            }
        }
    }
}



@Composable
fun ForgottenPasswordPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(25.dp))

        // Back button
        val context = LocalContext.current

        Text(
            text = stringResource(R.string.back_arrow),
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.clickable {
                (context as? Activity)?.finish()
            }
        )

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


@Preview(showBackground = true)
@Composable
fun ForgottenPasswordPagePreview() {
    ForgottenPasswordPage()
}