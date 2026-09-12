package com.example.instalogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.instalogin.homeAppScreens.InstagramBottomBar
import com.example.instalogin.homeAppScreens.home.InstagramPostItem
import com.example.instalogin.homeAppScreens.home.InstagramStories
import com.example.instalogin.homeAppScreens.home.InstagramTopBar
import com.example.instalogin.ui.theme.InstaLoginTheme
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instalogin.homeAppScreens.profile.EditProfileButton
import com.example.instalogin.homeAppScreens.profile.ProfileBioSection
import com.example.instalogin.homeAppScreens.profile.ProfileHeaderSection
import com.example.instalogin.homeAppScreens.profile.ProfileTabs
import com.example.instalogin.homeAppScreens.profile.ProfileTopBar

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaLoginTheme {
                InstagramMainScreen()
            }
        }
    }
}
@Composable
fun InstagramMainScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            InstagramBottomBar(navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(BottomNavItem.Home.route) {
                InstagramHomePage()
            }
            composable(BottomNavItem.Profile.route) {
                InstagramProfilePage()
            }
        }
    }
}



@Composable
fun InstagramHomePage() {

    val stories = listOf(
        stringResource(R.string.story_1),
        stringResource(R.string.story_2),
        stringResource(R.string.story_3),
        stringResource(R.string.story_4),
        stringResource(R.string.story_5)
    )

    val posts = listOf(
        Triple(
            stringResource(R.string.post_user_1),
            stringResource(R.string.post_title_1),
            stringResource(R.string.post_likes_1).toInt()
        ),
        Triple(
            stringResource(R.string.post_user_2),
            stringResource(R.string.post_title_2),
            stringResource(R.string.post_likes_2).toInt()
        ),
        Triple(
            stringResource(R.string.post_user_3),
            stringResource(R.string.post_title_3),
            stringResource(R.string.post_likes_3).toInt()
        )
    )



    Scaffold(
        topBar = { InstagramTopBar() }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            item {
                InstagramStories(stories)
            }

            items(posts) { post ->
                InstagramPostItem(post)
            }
        }
    }
}


@Composable
fun InstagramProfilePage() {

    Scaffold(
        topBar = { ProfileTopBar() }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            item { ProfileHeaderSection() }

            item { ProfileBioSection() }

            item { EditProfileButton() }

            item { ProfileTabs() }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    InstaLoginTheme {
        InstagramMainScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    InstaLoginTheme {
        InstagramProfilePage()
    }
}