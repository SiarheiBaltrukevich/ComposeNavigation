package com.boltic28.composenavigation.composables.activities

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.boltic28.composenavigation.viewmodels.SettingsVM

@Composable
fun SettingsFeed(model: SettingsVM) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "this is a ${model.text} screen!\n" +
                    " counter value is: ${model.count}"
        )
    }
}