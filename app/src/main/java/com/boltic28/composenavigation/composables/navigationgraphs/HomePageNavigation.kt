package com.boltic28.composenavigation.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.boltic28.composenavigation.composables.fragments.OrdersPage
import com.boltic28.composenavigation.composables.fragments.UserPage
import com.boltic28.composenavigation.composables.fragments.WelcomePage

@Composable
fun HomeNavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = WELCOME_FRAGMENT, modifier) {
        composable(WELCOME_FRAGMENT) {
            WelcomePage(hiltViewModel())
        }
        composable(PAST_ORDERS_FRAGMENT) {
            OrdersPage(hiltViewModel())
        }
        composable(USER_FRAGMENT) {
            UserPage(hiltViewModel())
        }
    }
}

// navigation destinations
const val WELCOME_FRAGMENT = "welcome"
const val USER_FRAGMENT = "user"
const val PAST_ORDERS_FRAGMENT = "orders"