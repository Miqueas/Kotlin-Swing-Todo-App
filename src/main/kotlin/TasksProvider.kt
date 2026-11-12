package io.github.miqueas.kotlin_swing_todo_app

import java.beans.*

class TasksProvider {
    private val notifier = PropertyChangeSupport(this)
    private val tasks: MutableList<TaskModel> = mutableListOf()

    companion object {
        private var instance: TasksProvider? = null

        fun getInstance(): TasksProvider {
            if (instance == null) {
                instance = TasksProvider()
            }

            return instance!!
        }
    }

    // Automatically casts to a read-only list
    fun getTasks(): List<TaskModel> = tasks

    fun onChange(listener: PropertyChangeListener) {
        notifier.addPropertyChangeListener(listener)
    }

    fun addTask(text: String, done: Boolean) {
        val task = TaskModel(tasks.size, text, done)
        tasks.add(task)
        notifier.firePropertyChange("add", null, tasks)
    }

    fun removeTask(id: Int) {
        tasks.removeAll { it.id == id }
        notifier.firePropertyChange("remove", null, tasks)
    }

    fun setDone(id: Int, done: Boolean) {
        for (i in tasks.indices) {
            val task = tasks[i]
            if (task.id == id) {
                tasks[i] = task.copy(done = done)
            }
        }

        notifier.firePropertyChange("update", null, tasks)
    }
}