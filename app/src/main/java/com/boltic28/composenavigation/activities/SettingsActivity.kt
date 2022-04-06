package com.boltic28.composenavigation.activities

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
import com.boltic28.composenavigation.composables.TopNavTabs
import com.boltic28.composenavigation.composables.activities.SettingsPage
import com.boltic28.composenavigation.ui.theme.ComposeNavigationTheme
import com.boltic28.composenavigation.viewmodels.SettingsVM

class SettingsActivity : ComponentActivity() {

    private val settingsVM: SettingsVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Settings Activity")
                        TopNavTabs()
                        SettingsPage(model = settingsVM)
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NotificationPreview() {
    ComposeNavigationTheme {
        Column {
            Greeting("Settings Activity")
            TopNavTabs()
            SettingsPage(model = SettingsVM("settings content"))
        }
    }
}
