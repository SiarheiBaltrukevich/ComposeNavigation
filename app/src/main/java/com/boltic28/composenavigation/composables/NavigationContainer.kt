package com.boltic28.composenavigation.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.boltic28.composenavigation.composables.fragments.OrdersPage
import com.boltic28.composenavigation.composables.fragments.UserPage
import com.boltic28.composenavigation.composables.fragments.WelcomePage

@Composable
fun HomeContainerHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = HOME_FRAGMENT, modifier) {
        composable(HOME_FRAGMENT) {
            WelcomePage(model = viewModel())
        }
        composable(PAST_ORDERS_FRAGMENT) {
            OrdersPage(model = viewModel())
        }
        composable(USER_FRAGMENT) {
            UserPage(model = viewModel())
        }
    }
}

// navigation destinations
const val HOME_FRAGMENT = "home"
const val USER_FRAGMENT = "user"
const val PAST_ORDERS_FRAGMENT = "orders"