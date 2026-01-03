package com.example.instalogin

import android.content.Intent
import androidx.compose.ui.platform.LocalContext
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaLogin()
        }
    }
}

@Composable
fun InstaLogin() {
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
            text = "English (India)",
            color = Color.LightGray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(80.dp))

        //Insta Logo
        Image(
            painter = painterResource(id = R.drawable.instagram),
            contentDescription = "Instagram Logo",
            modifier = Modifier
                .size(60.dp)
                .border(
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.background),
                    shape = RoundedCornerShape(12.dp)
                )
        )

        Spacer(modifier = Modifier.height(80.dp))

        //TextField for Username, email address or mobile number
        var username by remember { mutableStateOf("") }

        TextField(
            value = username,
            onValueChange = { username = it },
            placeholder = {
                Text("Username, email address or mobile number")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(1.dp, Color.DarkGray, RoundedCornerShape(8.dp))
        )


        Spacer(modifier = Modifier.height(12.dp))

        //TextField for Password
        var password by remember { mutableStateOf("") }

        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Text("Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(1.dp, Color.DarkGray, RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(12.dp))

        //Login Button
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0095F6)
            )
        ) {
            Text("Log in", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        //Clickable Text For Forgotten Password
        val context = LocalContext.current
        Text(
            text = "Forgotten password?",
            color = Color(0xFF0095F6),
            fontSize = 14.sp,
            modifier = Modifier.clickable {
                val intent = Intent(context, MainActivity2::class.java)
                context.startActivity(intent)
            }
        )

        Spacer(modifier = Modifier.height(150.dp))

        //Button Create new Account
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, Color(0xFF0095F6)),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.background
            )
        ) {
            Text(
                text = "Create new account",
                color = Color(0xFF0095F6)
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
                contentDescription = "Meta logo",
                modifier = Modifier.size(15.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = "Meta",
                color = Color.DarkGray,
                fontSize = 15.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InstaLoginPreview() {
    InstaLogin()
}
