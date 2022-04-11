package com.boltic28.composenavigation.viewmodels.fragmentmodels

import androidx.lifecycle.ViewModel
import com.boltic28.composenavigation.data.navcache.CacheKey
import com.boltic28.composenavigation.data.navcache.NavigationCache
import com.boltic28.composenavigation.data.Repository
import com.boltic28.composenavigation.data.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingInVM @Inject constructor(
    private val repository: Repository,
    private val cache: NavigationCache,
) : ViewModel() {

    private var user: User? = null

    private val _text = MutableStateFlow("SignIn Page.")
    val text = _text.asStateFlow()

    init {
        CoroutineScope(Dispatchers.Default).launch {
            checkCache()
        }
    }

    private suspend fun checkCache() {
        if (cache.isNotEmpty) {
            println("->> SignIn Page: cache is not empty: size: ${cache.size}")
            user = cache.getExtra(CacheKey.USER) as? User
            _text.emit(
                "Fragment: SignIn Page \n" +
                        "user is: $user\n" +
                        "cache size is: ${cache.size}\n" +
                        "------------------------------\n" +
                        "Signed In as ${user?.name}!"
            )
        }
    }
}