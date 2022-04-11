package com.boltic28.composenavigation.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val id: Long,
    val cost: Double,
    val name: String,
) : Parcelable