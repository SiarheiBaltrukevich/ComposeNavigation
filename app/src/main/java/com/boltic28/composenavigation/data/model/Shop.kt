package com.boltic28.composenavigation.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shop(
    val id: Long,
    val name: String,
) : Parcelable