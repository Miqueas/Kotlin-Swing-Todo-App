package io.github.miqueas.kotlin_swing_todo_app

import java.awt.Dimension
import javax.swing.*
import javax.swing.border.EmptyBorder

class BottomBar : JPanel {
    val checkBox = JCheckBox("Done", false)
    val input = JTextField(20)
    val provider = TasksProvider.getInstance()

    constructor() {
        layout = BoxLayout(this, BoxLayout.X_AXIS)
        border = EmptyBorder(10, 10, 10, 10)

        checkBox.font = Fonts.normal
        checkBox.isFocusPainted = false

        input.font = Fonts.normal
        input.addActionListener { addTask() }

        val addButton = JButton("Add")
        addButton.font = Fonts.normal
        addButton.isFocusPainted = false
        addButton.addActionListener { addTask() }

        add(checkBox)
        add(Box.createRigidArea(Dimension(10, 0)))
        add(input)
        add(Box.createRigidArea(Dimension(10, 0)))
        add(addButton)
    }

    private fun addTask() {
        val text = input.text
        if (text.isEmpty()) return
        provider.addTask(text, checkBox.isSelected)
        input.text = ""
    }
}