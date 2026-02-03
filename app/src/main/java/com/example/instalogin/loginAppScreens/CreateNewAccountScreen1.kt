package com.example.instalogin.loginAppScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instalogin.R

@Composable
fun CreateNewAccount1(
    onNavigateBack: () -> Unit,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp)
    ) {

        BackArrow { onNavigateBack() }

        Spacer(modifier = Modifier.height(24.dp))

        AppText(
            text = stringResource(R.string.what_is_your_no),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        AppText(text = stringResource(R.string.no_info_note))

        Spacer(modifier = Modifier.height(10.dp))

        var mobileNo by remember { mutableStateOf("") }
        AppOutlinedTextField(
            value = mobileNo,
            onValueChange = { mobileNo = it },
            hint = stringResource(R.string.mobile_no_hint)
        )

        Spacer(modifier = Modifier.height(4.dp))

        AppText(text = stringResource(R.string.security_note))

        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(
            text = stringResource(R.string.next),
            onClick = { }
        )

        Spacer(modifier = Modifier.height(14.dp))

        AppOutlinedButton(
            text = stringResource(R.string.sign_with_email),
            onClick = onButtonClick
        )


    }
}
