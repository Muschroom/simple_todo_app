package com.example.todooshka.data

data class TaskEntity (
    val id: String,
    val title: String,
    val isDone: Boolean = false
){}