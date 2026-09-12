package com.example.instalogin.homeAppScreens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.instalogin.R

@Composable
fun ProfileBioSection() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {

        Text(stringResource(R.string.profile_name))

        Spacer(modifier = Modifier.height(4.dp))

        Text(stringResource(R.string.profile_bio_line1))
        Text(stringResource(R.string.profile_bio_line2))
    }
}
