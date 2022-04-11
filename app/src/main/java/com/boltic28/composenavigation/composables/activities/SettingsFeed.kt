package com.boltic28.composenavigation.composables.activities

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.boltic28.composenavigation.viewmodels.SettingsVM

@Composable
fun SettingsFeed(
    model: SettingsVM = hiltViewModel()
) {
    val text = remember { model.text }.collectAsState()

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text.value
        )
    }
}