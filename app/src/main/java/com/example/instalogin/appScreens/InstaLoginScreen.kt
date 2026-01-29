package com.example.instalogin.appScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalogin.R

@Composable
fun InstaLogin(
    onForgotPasswordClick: () -> Unit,
    onCreateAcButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        AppText(
            text = stringResource(R.string.language_english_india),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(100.dp))

        Image(
            painter = painterResource(R.drawable.instagram),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))

        var username by remember { mutableStateOf("") }
        AppOutlinedTextField(
            value = username,
            onValueChange = { username = it },
            hint = stringResource(R.string.username_hint)
        )

        Spacer(modifier = Modifier.height(12.dp))

        var password by remember { mutableStateOf("") }
        AppOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            hint = stringResource(R.string.password_hint)
        )

        Spacer(modifier = Modifier.height(12.dp))

        PrimaryButton(
            text = stringResource(R.string.login),
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppText(
            text = stringResource(R.string.forgotten_password),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable { onForgotPasswordClick() }
        )

        Spacer(modifier = Modifier.height(150.dp))

        AppOutlinedButton(
            text = stringResource(R.string.create_new_account),
            onClick = onCreateAcButtonClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.meta),
                contentDescription = stringResource(R.string.meta_logo),
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            AppText(
                text = stringResource(R.string.meta),
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
