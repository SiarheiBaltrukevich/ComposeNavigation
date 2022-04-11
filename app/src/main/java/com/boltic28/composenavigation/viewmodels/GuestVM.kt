package com.boltic28.composenavigation.viewmodels

import androidx.lifecycle.ViewModel
import com.boltic28.composenavigation.data.UserManager
import com.boltic28.composenavigation.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuestVM @Inject constructor(
    userManager: UserManager,
) : ViewModel() {

    val user: User = userManager.currentUser

    val text: String = "Guest flow"
}
