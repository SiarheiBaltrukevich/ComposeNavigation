package com.boltic28.composenavigation.composables.navigationgraphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.boltic28.composenavigation.composables.fragments.*

@Composable
fun GuestNavigationHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = SIGN_IN_FRAGMENT, modifier) {
        composable(SIGN_IN_FRAGMENT) {
            SignInPage(hiltViewModel())
        }
        composable(LOCATION_FRAGMENT) {
            LocationPage(hiltViewModel())
        }
    }
}

// navigation destinations
const val SIGN_IN_FRAGMENT = "sign_in"
const val LOCATION_FRAGMENT = "location"
