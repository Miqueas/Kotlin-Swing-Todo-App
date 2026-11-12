package io.github.miqueas.kotlin_swing_todo_app

import java.awt.font.TextAttribute
import javax.swing.*
import java.awt.*

class TaskItem : JPanel {
    private val provider = TasksProvider.getInstance()
    private val task: TaskModel

    constructor(task: TaskModel) {
        this.task = task

        layout = BoxLayout(this, BoxLayout.LINE_AXIS)
        maximumSize = Dimension(Int.MAX_VALUE, 28)

        val checkBox = JCheckBox(task.text, task.done)
        checkBox.font = Fonts.normal.deriveFont(
            mapOf(TextAttribute.STRIKETHROUGH to task.done)
        )
        checkBox.isFocusPainted = false
        checkBox.addActionListener {
            provider.setDone(task.id, checkBox.isSelected)
        }

        val deleteButton = JButton("X")
        deleteButton.font = Fonts.bold
        deleteButton.isFocusPainted = false
        deleteButton.addActionListener { provider.removeTask(task.id) }

        add(checkBox)
        add(Box.createHorizontalGlue())
        add(deleteButton)
    }
}