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
import com.boltic28.composenavigation.data.*
import com.boltic28.composenavigation.data.navcache.CacheKey
import com.boltic28.composenavigation.data.navcache.NavigationCacheManager
import com.boltic28.composenavigation.ui.theme.ComposeNavigationTheme
import com.boltic28.composenavigation.viewmodels.HomeVM
import com.boltic28.composenavigation.viewmodels.fragmentmodels.WelcomeVM
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    @Inject lateinit var navControllerWrapper: NavControllerWrapper

    private val homeVM: HomeVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {

                // new one
                navControllerWrapper.initWith(rememberNavController())

                // standart
                val controller = rememberNavController()

                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting(name = "HomeActivity")
                        TopNavTabs(
                            onGuestClick = { startGuestActivity() },
                            onSettingsClick = { startSettingActivity() },
                        )
                        HomeFeed(model = homeVM)
                        HomeNavigationHost(navController = navControllerWrapper.controller,
                            Modifier
                                .fillMaxHeight()
                                .weight(0.9f))
                        BottomHomeNavTabs(
                            onWelcomeClick = { moveToWelcomePage() },
                            onOrdersClick = { moveToOrdersPage() },
                            onUserClick = { moveToUserPage() },
                        )
                    }
                }
                // we should decide where we can use it.
                // if you put this method out of setContentBlock it will not work, because controller not ready yet
                checkExtras()
            }
        }
    }

    private fun checkExtras() {
        val dest = intent.extras?.getString("dest")
        if (dest != null) {
            when(dest) {
                WELCOME_FRAGMENT -> moveToWelcomePage()
                PAST_ORDERS_FRAGMENT -> moveToOrdersPage()
                USER_FRAGMENT -> moveToUserPage()
            }
        } else {
            // load default destination
            moveToWelcomePage()
        }
    }

    private fun moveToWelcomePage() {
        navControllerWrapper
            .putExtra(CacheKey.USER, homeVM.user)
            .navigateTo(WELCOME_FRAGMENT)
        println("->> moveToWelcomePage")
    }

    private fun moveToOrdersPage() {
        navControllerWrapper
            .putExtra(CacheKey.ORDERS, homeVM.orders)
            .putExtra(CacheKey.SHOP, homeVM.shop)
            .putExtra(CacheKey.USER, homeVM.user)
            .navigateTo(PAST_ORDERS_FRAGMENT)
        println("->> moveToOrdersPage")
    }

    private fun moveToUserPage() {
        navControllerWrapper
            .putExtra(CacheKey.USER, homeVM.user)
            .navigateTo(USER_FRAGMENT)
        println("->> moveToUserPage")
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
            HomeFeed(model = HomeVM(Repository(), UserManager(Repository())))
            WelcomePage(model = WelcomeVM(Repository(), NavigationCacheManager()))
            BottomHomeNavTabs()
        }
    }
}