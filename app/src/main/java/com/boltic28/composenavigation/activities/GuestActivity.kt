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
import com.boltic28.composenavigation.composables.activities.GuestPage
import com.boltic28.composenavigation.ui.theme.ComposeNavigationTheme
import com.boltic28.composenavigation.viewmodels.GuestVM

class GuestActivity: ComponentActivity() {

    private val guestModel: GuestVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting("Guest Activity")
                        TopNavTabs()
                        GuestPage(model = guestModel)
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GuestPreview() {
    ComposeNavigationTheme {
        Column {
            Greeting("Guest Activity")
            TopNavTabs()
            GuestPage(model = GuestVM("guest content"))
        }
    }
}