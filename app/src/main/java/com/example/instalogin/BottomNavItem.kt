package com.example.instalogin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", Icons.Default.Home)
    object Search : BottomNavItem("search", Icons.Default.Search)
    object Add : BottomNavItem("add", Icons.Default.AddBox)
    object Reels : BottomNavItem("reels", Icons.Default.PlayArrow)
    object Profile : BottomNavItem("profile", Icons.Default.Person)
}
