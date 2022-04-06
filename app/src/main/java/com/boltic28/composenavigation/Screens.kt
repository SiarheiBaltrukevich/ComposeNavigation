package com.boltic28.composenavigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.boltic28.composenavigation.composables.fragments.OrdersPage
import com.boltic28.composenavigation.composables.fragments.UserPage
import com.boltic28.composenavigation.composables.fragments.WelcomePage
import com.boltic28.composenavigation.viewmodels.fragmentmodels.OrdersVM
import com.boltic28.composenavigation.viewmodels.fragmentmodels.UserVM
import com.boltic28.composenavigation.viewmodels.fragmentmodels.WelcomeVM

enum class Screens(
    val body: @Composable (ViewModel) -> Unit
) {

    Orders(
        body = { vm -> OrdersPage(model = vm as OrdersVM) }
    ),
    Welcome(
        body = { vm -> WelcomePage(model = vm as WelcomeVM) }
    ),
    User(
        body = { vm -> UserPage(model = vm as UserVM) }
    );

    @Composable
    fun content(onScreenChange: ViewModel) {
        body(onScreenChange)
    }

    companion object {
        fun fromRoute(route: Destinations): Screens =
            when (route) {
                Destinations.ORDERS -> Orders
                Destinations.WELCOME -> Welcome
                Destinations.USER -> User
            }
    }
}

enum class Destinations {
    ORDERS, WELCOME, USER
}