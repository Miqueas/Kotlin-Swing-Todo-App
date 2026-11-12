package io.github.miqueas.kotlin_swing_todo_app

import javax.swing.border.EmptyBorder
import javax.swing.*
import java.awt.*

class AboutWindow : JFrame {
    constructor(parent: Component?) {
        val closeOp = if (parent == null) EXIT_ON_CLOSE else DISPOSE_ON_CLOSE

        defaultCloseOperation = closeOp
        isResizable = false
        title = "About Window"

        val title = JLabel("Todo")
        val description = JLabel("A simple todo app in Kotlin")
        val author = JLabel("Author: Josué Martínez")
        val version = JLabel("0.1.0")
        val closeButton = JButton("Close")
        val content = JPanel()

        title.font = Fonts.display
        title.alignmentX = CENTER_ALIGNMENT

        description.font = Fonts.normal
        description.alignmentX = CENTER_ALIGNMENT

        author.font = Fonts.normal
        author.alignmentX = CENTER_ALIGNMENT

        version.font = Fonts.normal
        version.alignmentX = CENTER_ALIGNMENT

        closeButton.font = Fonts.normal
        closeButton.alignmentX = CENTER_ALIGNMENT
        closeButton.isFocusPainted = false
        closeButton.addActionListener { _ -> dispose() }

        content.layout = BoxLayout(content, BoxLayout.Y_AXIS)
        content.border = EmptyBorder(10, 10, 10, 10)
        content.add(title)
        content.add(description)
        content.add(Box.createRigidArea(Dimension(0, 10)))
        content.add(author)
        content.add(version)
        content.add(Box.createRigidArea(Dimension(0, 10)))
        content.add(closeButton)

        contentPane = content
        pack()
        setLocationRelativeTo(parent)
        isVisible = true
    }
}