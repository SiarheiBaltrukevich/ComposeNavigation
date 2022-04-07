package com.boltic28.composenavigation.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor() {

    private var _counter = 0
    val counter
        get() = _counter++
}