package com.example.todooshka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.todooshka.data.FakeTasksRepository
import com.example.todooshka.presentation.AppNavHost
import com.example.todooshka.ui.theme.ToDooshkaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var darkTheme by remember { mutableStateOf(false) }
            val repository = remember { FakeTasksRepository() }

            ToDooshkaTheme(darkTheme = darkTheme) {
                AppNavHost(
                    repository = repository,
                    darkTheme = darkTheme,
                    onThemeChanged = { newTheme -> darkTheme = newTheme }
                )
            }
        }
    }
}