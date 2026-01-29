package com.example.instalogin.appScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalogin.R

//Forgotten Password Screen (Email or Username)
@Composable
fun ForgottenPasswordPage1(
    onNavigateBack: () -> Unit,
    onSearchClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        BackArrow { onNavigateBack() }

        Spacer(modifier = Modifier.height(24.dp))

        AppText(
            text = stringResource(R.string.find_account),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        AppText(text = stringResource(R.string.enter_email_or_username))

        AppText(
            text = stringResource(R.string.cant_reset_password),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable { }
        )

        Spacer(modifier = Modifier.height(24.dp))

        var emailOrUsername by remember { mutableStateOf("") }
        AppOutlinedTextField(
            value = emailOrUsername,
            onValueChange = { emailOrUsername = it },
            hint = stringResource(R.string.email_or_username_hint)
        )

        Spacer(modifier = Modifier.height(4.dp))

        AppText(text = stringResource(R.string.security_note))

        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(
            text = stringResource(R.string.continue_),
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppText(
            text = stringResource(R.string.search_by_mobile),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { onSearchClick() }
        )

        Spacer(modifier = Modifier.height(24.dp))

        AppText(
            text = stringResource(R.string.or_divider),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        AppOutlinedButton(
            text = stringResource(R.string.login_with_facebook),
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            icon = painterResource(R.drawable.facebook),
            iconDescription = "Facebook"
        )
    }
}
