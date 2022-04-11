package com.boltic28.composenavigation.data.navcache

import com.boltic28.composenavigation.data.NavControllerWrapper

/**
 * Use this interface in [NavControllerWrapper] only
 * to prepare data for destination page
 */

interface NavigationCacheSetter {

    fun sendData()

    fun putExtra(key: CacheKey, extra: Any)
}