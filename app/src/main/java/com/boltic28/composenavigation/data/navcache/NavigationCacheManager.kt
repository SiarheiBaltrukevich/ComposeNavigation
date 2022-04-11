package com.boltic28.composenavigation.data.navcache

import javax.inject.Inject
import javax.inject.Singleton
import com.boltic28.composenavigation.data.NavControllerWrapper

/**
 * Class keeps data for navigation.
 * put data by using [NavControllerWrapper]
 * get data in ViewModels
 */

@Singleton
class NavigationCacheManager @Inject constructor()
    : NavigationCacheSetter, NavigationCache {

    private val _preparedData = mutableMapOf<CacheKey, Any>()

    private val _passedData = mutableMapOf<CacheKey, Any>()
    override val extras: Map<CacheKey, Any> = _passedData

    override val isEmpty: Boolean
        get() = _passedData.isEmpty()

    override val isNotEmpty: Boolean
        get() = _passedData.isNotEmpty()

    override val size: Int
        get() = _passedData.size

    override fun sendData() {
        _passedData.clear()
        _passedData.putAll(_preparedData)
        _preparedData.clear()
    }

    override fun putExtra(key: CacheKey, extra: Any) {
        _preparedData[key] = extra
        println("->> put extra")
    }

    override fun getExtra(key: CacheKey): Any? = _passedData[key]
}

enum class CacheKey {
    USER, ORDER, SHOP, ITEM, ID, ORDERS, SHOPS, USERS, ITEMS
}