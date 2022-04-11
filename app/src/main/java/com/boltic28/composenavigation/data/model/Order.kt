package com.boltic28.composenavigation.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Order(
    val id: Long,
    val shopId: Long,
    val userId: Long,
    val positions: List<Item>
) : Parcelable {
    val total: String
        get() = "$${positions.sumOf { it.cost }}"
}

