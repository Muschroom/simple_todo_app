package com.example.todooshka.data
import  kotlinx.coroutines.delay
class FakeTasksRepository  {
    private val tasks = mutableListOf(
        TaskEntity(id = "1", title = "Review code"),
        TaskEntity(id = "2", title = "Learn Compose"),
        TaskEntity(id = "3", title = "Make some coffee"),
        TaskEntity(id = "4", title = "Go to bed"),
    )

    suspend fun getTasks(): List<TaskEntity> {
        delay(timeMillis = 500) // okHttp.get
        return tasks
    }

    suspend fun getTask(id: String): TaskEntity? {
        delay(timeMillis = 500)
        return tasks.firstOrNull { it.id == id }
    }

    suspend fun toggleDone(id: String, isDone: Boolean): TaskEntity? {
        delay(timeMillis = 500)
        val index = tasks.indexOfFirst { it.id == id }
        if (index < 0) return null

        val updated = tasks[index].copy(isDone = isDone)
        tasks[index] = updated
        return updated
    }
}