package com.boltic28.composenavigation.viewmodels

import androidx.lifecycle.ViewModel
import com.boltic28.composenavigation.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuestVM @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    val text: String = "Guest flow"
    val count: String
        get() =  repository.counter.toString()
}
