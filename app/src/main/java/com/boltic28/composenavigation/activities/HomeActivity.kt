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
import com.boltic28.composenavigation.composables.BottomNavTabs
import com.boltic28.composenavigation.composables.Greeting
import com.boltic28.composenavigation.composables.TopNavTabs
import com.boltic28.composenavigation.composables.fragments.WelcomePage
import com.boltic28.composenavigation.ui.theme.ComposeNavigationTheme
import com.boltic28.composenavigation.viewmodels.HomeVM
import com.boltic28.composenavigation.viewmodels.fragmentmodels.OrdersVM
import com.boltic28.composenavigation.viewmodels.fragmentmodels.UserVM
import com.boltic28.composenavigation.viewmodels.fragmentmodels.WelcomeVM

class HomeActivity : ComponentActivity() {

    private val homeVM: HomeVM by viewModels()
    private val ordersVM: OrdersVM by viewModels()
    private val userVM: UserVM by viewModels()
    private val welcomeVM: WelcomeVM by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Greeting(name = "HomeActivity")
                        TopNavTabs()
                        WelcomePage(model = welcomeVM)
                        BottomNavTabs()
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeNavigationTheme {
        Column {
            Greeting("Home Activity")
            TopNavTabs()
            WelcomePage(model = WelcomeVM("welcome"))
            BottomNavTabs()
        }
    }
}