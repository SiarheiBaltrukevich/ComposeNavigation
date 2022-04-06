package com.boltic28.composenavigation.composables.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.boltic28.composenavigation.viewmodels.fragmentmodels.WelcomeVM

@Composable
fun WelcomePage(model: WelcomeVM) {
    Box(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.9f),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "this is a ${model.text} fragment!"
        )
    }
}