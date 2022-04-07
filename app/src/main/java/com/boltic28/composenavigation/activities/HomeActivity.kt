package com.boltic28.composenavigation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.boltic28.composenavigation.composables.*
import com.boltic28.composenavigation.composables.activities.HomeFeed
import com.boltic28.composenavigation.composables.fragments.WelcomePage
import com.boltic28.composenavigation.data.Repository
import com.boltic28.composenavigation.ui.theme.ComposeNavigationTheme
import com.boltic28.composenavigation.viewmodels.HomeVM
import com.boltic28.composenavigation.viewmodels.fragmentmodels.WelcomeVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val homeVM: HomeVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {

                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting(name = "HomeActivity")
                        TopNavTabs(
                            onGuestClick = { startGuestActivity() },
                            onSettingsClick = { startSettingActivity() },
                        )
                        HomeFeed(model = homeVM)
                        HomeNavigationHost(navController = navController,
                            Modifier
                                .fillMaxHeight()
                                .weight(0.9f))
                        BottomHomeNavTabs(
                            onWelcomeClick = { navController.navigate(WELCOME_FRAGMENT) },
                            onOrdersClick = { navController.navigate(PAST_ORDERS_FRAGMENT) },
                            onUserClick = { navController.navigate(USER_FRAGMENT) },
                        )
                    }
                }
            }
        }
    }

    private fun startSettingActivity() {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    private fun startGuestActivity() {
        startActivity(Intent(this, GuestActivity::class.java))
    }

}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeNavigationTheme {
        Column {
            Greeting("Home Activity")
            TopNavTabs()
            HomeFeed(model = HomeVM(Repository()))
            WelcomePage(model = WelcomeVM(Repository()))
            BottomHomeNavTabs()
        }
    }
}