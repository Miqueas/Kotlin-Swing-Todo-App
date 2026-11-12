package io.github.miqueas.kotlin_swing_todo_app

import java.beans.*
import java.util.UUID

class TasksProvider {
    private val _notifier = PropertyChangeSupport(this)
    private val _tasks: MutableList<TaskModel> = mutableListOf()
    // Automatically casts to a read-only list
    val tasks: List<TaskModel> = _tasks

    companion object {
        private var _instance: TasksProvider? = null
        val instance: TasksProvider get() {
            if (_instance == null) {
                _instance = TasksProvider()
            }

            return _instance!!
        }
    }

    fun onChange(listener: PropertyChangeListener) {
        _notifier.addPropertyChangeListener(listener)
    }

    fun addTask(text: String, done: Boolean) {
        val task = TaskModel(UUID.randomUUID(), text, done)
        _tasks.add(task)
        _notifier.firePropertyChange("add", null, _tasks)
    }

    fun removeTask(id: UUID) {
        _tasks.removeAll { it.id == id }
        _notifier.firePropertyChange("remove", null, _tasks)
    }

    fun setDone(id: UUID, done: Boolean) {
        for (i in _tasks.indices) {
            val task = _tasks[i]
            if (task.id == id) {
                _tasks[i] = task.copy(done = done)
            }
        }

        _notifier.firePropertyChange("update", null, _tasks)
    }
}