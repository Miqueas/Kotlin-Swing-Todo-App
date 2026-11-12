package io.github.miqueas.kotlin_swing_todo_app

import com.formdev.flatlaf.FlatClientProperties
import javax.swing.border.EmptyBorder
import javax.swing.*
import java.awt.*

class TasksView : JPanel {
    private val provider = TasksProvider.getInstance()
    private val list = JPanel()

    constructor() {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        border = EmptyBorder(10, 10, 10, 10)

        list.layout = BoxLayout(list, BoxLayout.Y_AXIS)

        val title = JLabel("Todo")
        val scroll = JScrollPane(list)

        title.font = Fonts.title
        title.alignmentX = LEFT_ALIGNMENT

        scroll.alignmentX = LEFT_ALIGNMENT
        scroll.maximumSize = Dimension(Int.MAX_VALUE, Int.MAX_VALUE)
        scroll.putClientProperty(
            FlatClientProperties.STYLE,
            "borderColor: #00000000"
        )

        add(title)
        add(Box.createRigidArea(Dimension(0, 10)))
        add(scroll)

        build()
        provider.onChange { rebuild() }
    }

    private fun build() {
        val tasks = provider.getTasks()

        for (task in tasks) {
            list.add(TaskItem(task))
        }

        revalidate()
        repaint()
    }

    private fun rebuild() {
        list.removeAll()
        build()
    }
}