package com.boltic28.composenavigation.data.navcache

interface NavigationCache {

    val extras: Map<CacheKey, Any>

    val isEmpty: Boolean

    val isNotEmpty: Boolean

    val size: Int

    fun getExtra(key: CacheKey): Any?
}