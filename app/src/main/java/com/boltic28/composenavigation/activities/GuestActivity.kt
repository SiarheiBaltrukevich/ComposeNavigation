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
import com.boltic28.composenavigation.composables.BottomGuestNavTabs
import com.boltic28.composenavigation.composables.Greeting
import com.boltic28.composenavigation.composables.TopNavTabs
import com.boltic28.composenavigation.composables.activities.GuestFeed
import com.boltic28.composenavigation.composables.fragments.SignInPage
import com.boltic28.composenavigation.composables.navigationgraphs.GuestNavigationHost
import com.boltic28.composenavigation.composables.navigationgraphs.LOCATION_FRAGMENT
import com.boltic28.composenavigation.composables.navigationgraphs.SIGN_IN_FRAGMENT
import com.boltic28.composenavigation.data.Repository
import com.boltic28.composenavigation.ui.theme.ComposeNavigationTheme
import com.boltic28.composenavigation.viewmodels.GuestVM
import com.boltic28.composenavigation.viewmodels.fragmentmodels.SingInVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuestActivity: ComponentActivity() {

    private val guestModel: GuestVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {

                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Guest Activity")
                        TopNavTabs(
                            onHomeClick = { startHomeActivity() },
                            onSettingsClick = { startSettingActivity() },
                        )
                        GuestFeed(model = guestModel)
                        GuestNavigationHost(navController = navController, Modifier
                            .fillMaxHeight()
                            .weight(0.9f))
                        BottomGuestNavTabs(
                            onSignInClick = {navController.navigate(SIGN_IN_FRAGMENT)},
                            onLocationClick = {navController.navigate(LOCATION_FRAGMENT)},
                        )
                    }
                }
            }
        }
    }

    private fun startSettingActivity() {
        startActivity(Intent(this, SettingsActivity::class.java))
    }

    private fun startHomeActivity() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}

@Preview(showSystemUi = true)
@Composable
fun GuestPreview() {
    ComposeNavigationTheme {
        Column {
            Greeting("Guest Activity")
            TopNavTabs()
            GuestFeed(model = GuestVM(Repository()))
            SignInPage(model = SingInVM(Repository()))
            BottomGuestNavTabs()
        }
    }
}