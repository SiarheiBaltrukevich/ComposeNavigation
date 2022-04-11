package com.boltic28.composenavigation.data

import android.content.Context
import androidx.navigation.NavHostController
import com.boltic28.composenavigation.data.navcache.CacheKey
import com.boltic28.composenavigation.data.navcache.NavigationCacheSetter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NavControllerWrapper @Inject constructor(
    @ApplicationContext context: Context,
    private val navigationCache: NavigationCacheSetter,
) : NavHostController(context) {

    private var _navController: NavHostController? = null
    val controller: NavHostController
        get() = requireNotNull(_navController) {
            "NavController is not initialized, call initWith(NavHostController) method before"
        }

    fun initWith(controller: NavHostController) {
        _navController = controller
        println("->> set controller: controller is: $_navController")
    }

    fun navigateTo(route: String) {
        navigationCache.sendData()
        _navController?.navigate(route)
    }

    fun putExtra(key: CacheKey, value: Any): NavControllerWrapper {
        navigationCache.putExtra(key, value)
        return this
    }
}