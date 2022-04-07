package com.boltic28.composenavigation.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boltic28.composenavigation.ui.theme.ComposeNavigationTheme

@Composable
fun Greeting(name: String) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "this is a $name!")
    }
}

@Composable
fun TopNavTabs(
    onGuestClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier.height(40.dp),
    ) {
        TextButton(
            onClick = onGuestClick,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.3f)
                .border(1.dp, Color.LightGray),
        ) {
            Text(text = "Guest", textAlign = TextAlign.Center)
        }
        TextButton(
            onClick = onHomeClick,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.3f)
                .border(1.dp, Color.LightGray),
        ) {
            Text(text = "Home", textAlign = TextAlign.Center)
        }
        TextButton(
            onClick = onSettingsClick,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.3f)
                .border(1.dp, Color.LightGray),
        ) {
            Text(text = "Settings", textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopNavTabsPreview() {
    ComposeNavigationTheme {
        Column {
            TopNavTabs()
        }
    }
}

@Composable
fun BottomHomeNavTabs(
    onWelcomeClick: () -> Unit = {},
    onOrdersClick: () -> Unit = {},
    onUserClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier.height(40.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        TextButton(
            onClick = onWelcomeClick,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.3f)
                .border(1.dp, Color.LightGray),
        ) {
            Text(text = "Welcome", textAlign = TextAlign.Center)
        }
        TextButton(
            onClick = onOrdersClick,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.3f)
                .border(1.dp, Color.LightGray),
        ) {
            Text(text = "Orders", textAlign = TextAlign.Center)
        }
        TextButton(
            onClick = onUserClick,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.3f)
                .border(1.dp, Color.LightGray),
        ) {
            Text(text = "User", textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomHomeNavTabsPreview() {
    ComposeNavigationTheme {
        Column {
            BottomHomeNavTabs()
        }
    }
}

@Composable
fun BottomGuestNavTabs(
    onSignInClick: () -> Unit = {},
    onLocationClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier.height(40.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        TextButton(
            onClick = onSignInClick,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.3f)
                .border(1.dp, Color.LightGray),
        ) {
            Text(text = "SignIn", textAlign = TextAlign.Center)
        }
        TextButton(
            onClick = onLocationClick,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.3f)
                .border(1.dp, Color.LightGray),
        ) {
            Text(text = "Location", textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomGuestNavTabsPreview() {
    ComposeNavigationTheme {
        Column {
            BottomGuestNavTabs()
        }
    }
}