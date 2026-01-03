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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForgottenPasswordPage()
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
            text = "<--",
            fontSize = 22.sp,
            modifier = Modifier.clickable {
                (context as? Activity)?.finish()
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        //Text
        Text(
            text = "Find your account",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Enter your email address or username.",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Text(
            text = "Can't reset your password?",
            color = Color(0xFF1B74E4),
            fontSize = 14.sp,
            modifier = Modifier.clickable {
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // LoginInfo TextFiled
        var loginInfo by remember { mutableStateOf("") }

        TextField(
            value = loginInfo,
            onValueChange = { loginInfo = it },
            placeholder = {
                Text("Email address or username")
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "You may receive whatsApp ans SMS notification " +
                "for security and login purposes",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Continue button
        Button(
            onClick = {
                // handle continue
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1B74E4)
            )
        ) {
            Text(
                text = "Continue",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Search by mobile number instead",
            color = Color(0xFF1B74E4),
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable {}
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "---------------------------------------- OR ------------------------------------------",
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
            Text("Log In With Facebook")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ForgottenPasswordPagePreview() {
    ForgottenPasswordPage()
}