package com.boltic28.composenavigation.composables.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.boltic28.composenavigation.viewmodels.fragmentmodels.LocationVM

@Composable
fun LocationPage(model: LocationVM) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "this is a ${model.text} fragment!\n" +
                    " counter value is: ${model.count}"
        )
    }
}