package com.example.todooshka.presentation
import com.example.todooshka.data.TaskEntity
data class TasksState(
    val query: String = "",
    val tasks: List<TaskEntity> = emptyList(),
    val isLoading: Boolean = false,
)