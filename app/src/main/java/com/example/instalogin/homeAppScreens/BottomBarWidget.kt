package com.example.instalogin.homeAppScreens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable

@Composable
fun InstagramBottomBar() {
    NavigationBar {
        listOf(
            Icons.Default.Home,
            Icons.Default.Search,
            Icons.Default.AddBox,
            Icons.Default.PlayArrow,
            Icons.Default.Person
        ).forEach {
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = { Icon(it, null) }
            )
        }
    }
}
