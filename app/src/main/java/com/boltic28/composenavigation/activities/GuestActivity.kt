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
import com.boltic28.composenavigation.data.*
import com.boltic28.composenavigation.data.navcache.CacheKey
import com.boltic28.composenavigation.data.navcache.NavigationCacheManager
import com.boltic28.composenavigation.ui.theme.ComposeNavigationTheme
import com.boltic28.composenavigation.viewmodels.GuestVM
import com.boltic28.composenavigation.viewmodels.fragmentmodels.SingInVM
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GuestActivity: ComponentActivity() {

    @Inject lateinit var navControllerWrapper: NavControllerWrapper

    private val guestModel: GuestVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeNavigationTheme {

                navControllerWrapper.initWith(rememberNavController())

                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Guest Activity")
                        TopNavTabs(
                            onHomeClick = { startHomeActivity() },
                            onSettingsClick = { startSettingActivity() },
                        )
                        GuestFeed(model = guestModel)
                        GuestNavigationHost(navController = navControllerWrapper.controller, Modifier
                            .fillMaxHeight()
                            .weight(0.9f))
                        BottomGuestNavTabs(
                            onSignInClick = { moveToSignInPage() },
                            onLocationClick = { moveToLocationPage() },
                        )
                    }
                }
            }
        }

        // load default destination
        moveToSignInPage()
    }

    private fun moveToSignInPage() {

        navControllerWrapper
            .putExtra(CacheKey.USER, guestModel.user)
            .putExtra(CacheKey.ID, 3)
            .navigateTo(SIGN_IN_FRAGMENT)
        println("->> moveToSignInPage")
    }

    private fun moveToLocationPage() {
        navControllerWrapper
            .navigateTo(LOCATION_FRAGMENT)
        println("->> moveToLocationPage")
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
            GuestFeed(model = GuestVM(UserManager(Repository())))
            SignInPage(model = SingInVM(Repository(), NavigationCacheManager()))
            BottomGuestNavTabs()
        }
    }
}