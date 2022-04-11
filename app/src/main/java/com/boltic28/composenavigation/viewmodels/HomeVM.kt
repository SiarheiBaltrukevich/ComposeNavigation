package com.boltic28.composenavigation.viewmodels

import androidx.lifecycle.ViewModel
import com.boltic28.composenavigation.data.Repository
import com.boltic28.composenavigation.data.UserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    repository: Repository,
    userManager: UserManager,
) : ViewModel() {

    val user = userManager.currentUser

    val orders = repository.getOrdersForUser(user)

    val shop = repository.shops.random()

    val shopOrders = repository.getOrdersForShop(shop)

    val text: String = "Home feed"
}