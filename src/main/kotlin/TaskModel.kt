package io.github.miqueas.kotlin_swing_todo_app

import java.util.UUID

data class TaskModel(val id: UUID, val text: String, val done: Boolean)