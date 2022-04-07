package com.boltic28.composenavigation.viewmodels.fragmentmodels

import androidx.lifecycle.ViewModel
import com.boltic28.composenavigation.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserVM @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    val text: String = "User details"
    val count: String
        get() =  repository.counter.toString()
}
