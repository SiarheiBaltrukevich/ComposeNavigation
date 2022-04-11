package com.boltic28.composenavigation.di

import com.boltic28.composenavigation.data.navcache.NavigationCache
import com.boltic28.composenavigation.data.navcache.NavigationCacheManager
import com.boltic28.composenavigation.data.navcache.NavigationCacheSetter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    @Binds
    @Singleton
    abstract fun provideCache(cache: NavigationCacheManager): NavigationCache

    @Binds
    @Singleton
    abstract fun provideCacheSetter(cache: NavigationCacheManager): NavigationCacheSetter
}