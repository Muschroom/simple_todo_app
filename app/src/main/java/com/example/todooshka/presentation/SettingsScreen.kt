package com.example.todooshka.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsRoute(
    darkTheme: Boolean,
    onThemeChanged: (Boolean) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    SettingsScreen(
        darkTheme = darkTheme,
        onThemeChanged = onThemeChanged,
        onBack = onBack,
        modifier = modifier
    )
}

@Composable
fun SettingsScreen(
    darkTheme: Boolean,
    onThemeChanged: (Boolean) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineLarge
            )

            OutlinedButton(
                onClick = { onThemeChanged(!darkTheme) }
            ) {
                Text(
                    text = if (darkTheme) "Light" else "Dark"
                )
            }

            OutlinedButton(
                onClick = onBack
            ) {
                Text(text = "go back")
            }
        }
    }
}