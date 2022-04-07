package com.boltic28.composenavigation.composables.activities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.boltic28.composenavigation.viewmodels.GuestVM

@Composable
fun GuestFeed(model: GuestVM) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "this is a ${model.text} screen!\n" +
                    " counter value is: ${model.count}"
        )
    }
}