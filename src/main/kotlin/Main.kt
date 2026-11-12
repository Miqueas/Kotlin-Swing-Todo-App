package io.github.miqueas.kotlin_swing_todo_app

import com.formdev.flatlaf.fonts.inter.FlatInterFont
import com.formdev.flatlaf.themes.FlatMacDarkLaf
import com.formdev.flatlaf.util.SystemInfo
import javax.swing.*

fun main() {
    if (SystemInfo.isMacOS) {
        System.setProperty("apple.laf.useScreenMenuBar", "true")
        System.setProperty("apple.awt.application.name", "Kotlin Swing Todo App")
        System.setProperty("apple.awt.application.appearance", "system")
    }

    if (SystemInfo.isLinux) {
        JFrame.setDefaultLookAndFeelDecorated(true)
        JDialog.setDefaultLookAndFeelDecorated(true)
    }

    SwingUtilities.invokeLater {
        FlatMacDarkLaf.setup()
        FlatInterFont.installLazy()

        val window = AppWindow()
        window.isVisible = true
    }
}