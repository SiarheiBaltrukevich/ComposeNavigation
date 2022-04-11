package com.boltic28.composenavigation.viewmodels

import androidx.lifecycle.ViewModel
import com.boltic28.composenavigation.data.navcache.NavigationCache
import com.boltic28.composenavigation.data.UserManager
import com.boltic28.composenavigation.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsVM @Inject constructor(
    private val userManager: UserManager,
    private val cache: NavigationCache,
) : ViewModel() {

    var user: User = userManager.currentUser

    private val _text = MutableStateFlow("Settings Page.")
    val text = _text.asStateFlow()

    init {
        CoroutineScope(Dispatchers.Default).launch {
            checkUserData()
        }
    }

    private suspend fun checkUserData() {
        println("->> Settings Page: cache is not empty: size: ${cache.size}")
        user = userManager.currentUser
        _text.emit(
            "Activity: Settings Page \n" +
                    "user is: $user\n" +
                    "cache size is: ${cache.size}\n" +
                    "------------------------------\n" +
                    "Settings for ${user.name}!"
        )
    }
}