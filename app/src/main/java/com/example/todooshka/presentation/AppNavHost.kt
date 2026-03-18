package com.example.todooshka.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todooshka.data.FakeTasksRepository

object Routes {
    const val TASKS = "tasks"
    const val TASK_DETAILED = "task"
    const val SETTINGS = "settings"
}

@Composable
fun AppNavHost(
    repository: FakeTasksRepository,
    darkTheme: Boolean,
    onThemeChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val viewModel = remember(key1 = repository) {
        TasksViewModel(repository = repository)
    }

    NavHost(
        navController = navController,
        startDestination = Routes.TASKS,
        modifier = modifier
    ) {
        composable(Routes.TASKS) {
            TasksRoute(
                viewModel = viewModel,
                onTaskClick = { id ->
                    navController.navigate(route = "${Routes.TASK_DETAILED}/$id")
                },
                onSettingsClick = {
                    navController.navigate(route = Routes.SETTINGS)
                }
            )
        }

        composable(
            route = "${Routes.TASK_DETAILED}/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            val taskId = entry.arguments?.getString("id").orEmpty()
            TaskDetailRoute(
                id = taskId,
                viewModel = viewModel,
                onBack = navController::popBackStack
            )
        }

        composable(Routes.SETTINGS) {
            SettingsRoute(
                darkTheme = darkTheme,
                onThemeChanged = onThemeChanged,
                onBack = navController::popBackStack
            )
        }
    }
}