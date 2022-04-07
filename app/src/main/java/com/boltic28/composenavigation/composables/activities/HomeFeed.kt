package com.boltic28.composenavigation.composables.activities

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.boltic28.composenavigation.ui.theme.SuperLightGray
import com.boltic28.composenavigation.viewmodels.HomeVM

@Composable
fun HomeFeed(model: HomeVM) {
    Box(
        modifier = Modifier.fillMaxWidth().background(SuperLightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "this is a ${model.text} screen!\n" +
                    " counter value is: ${model.count}"
        )
    }
}