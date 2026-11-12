package io.github.miqueas.kotlin_swing_todo_app

import com.formdev.flatlaf.extras.FlatDesktop
import kotlin.system.exitProcess
import javax.swing.*
import java.awt.*

class AppWindow : JFrame {
    constructor() {
        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 600)
        setLocationRelativeTo(null)
        title = "Todo"

        val menuBar = JMenuBar()
        val fileMenu = JMenu("File")
        val aboutButton = JMenuItem("About")
        val exitButton = JMenuItem("Exit")
        val tasksView = TasksView()
        val bottomBar = BottomBar()

        aboutButton.font = Fonts.normal
        aboutButton.addActionListener { _ -> AboutWindow(this) }

        exitButton.font = Fonts.normal
        exitButton.addActionListener { _ -> exitProcess(0) }

        fileMenu.add(aboutButton)
        fileMenu.add(exitButton)
        menuBar.add(fileMenu)

        jMenuBar = menuBar

        contentPane.add(BorderLayout.CENTER, tasksView)
        contentPane.add(BorderLayout.PAGE_END, bottomBar)

        FlatDesktop.setAboutHandler {}
        FlatDesktop.setQuitHandler { response -> response.performQuit() }
    }
}