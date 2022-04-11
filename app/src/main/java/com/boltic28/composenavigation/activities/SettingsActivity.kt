package com.boltic28.composenavigation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.boltic28.composenavigation.composables.Greeting
import com.boltic28.composenavigation.composables.OpenOrdersButton
import com.boltic28.composenavigation.composables.PAST_ORDERS_FRAGMENT
import com.boltic28.composenavigation.composables.TopNavTabs
import com.boltic28.composenavigation.composables.activities.SettingsFeed
import com.boltic28.composenavigation.data.NavControllerWrapper
import com.boltic28.composenavigation.data.navcache.NavigationCacheManager
import com.boltic28.composenavigation.data.Repository
import com.boltic28.composenavigation.data.UserManager
import com.boltic28.composenavigation.ui.theme.ComposeNavigationTheme
import com.boltic28.composenavigation.viewmodels.SettingsVM
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {

    @Inject lateinit var navControllerWrapper: NavControllerWrapper

    private val settingsVM: SettingsVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Settings Activity")
                        TopNavTabs(
                            onGuestClick = { startGuestActivity() },
                            onHomeClick = { startHomeActivity() },
                        )
                        SettingsFeed(model = settingsVM)
                        OpenOrdersButton(onClick = { openOrdersPage() })
                    }
                }
            }
        }
    }

    private fun startGuestActivity() {
        startActivity(Intent(this, GuestActivity::class.java))
    }

    private fun startHomeActivity(intent: Intent? = null) {
        startActivity(intent ?: Intent(this, HomeActivity::class.java))
    }

    // to open fragment on another activity we should send destination
    private fun openOrdersPage() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("dest", PAST_ORDERS_FRAGMENT)
        startHomeActivity(intent)
    }
}

@Preview(showSystemUi = true)
@Composable
fun NotificationPreview() {
    ComposeNavigationTheme {
        Column {
            Greeting("Settings Activity")
            TopNavTabs()
            SettingsFeed(model = SettingsVM(UserManager(Repository()), NavigationCacheManager()))
            OpenOrdersButton { }
        }
    }
}
