package com.github.irismessage.sessionterminatedcodeass

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.ApplicationNamesInfo
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JComponent
import javax.swing.JLabel
import javax.swing.JPanel

private class DummyDialogWrapper(project: Project?) : DialogWrapper(project) {
    init {
        title = ApplicationNamesInfo.getInstance().fullProductName
        init()
    }

    override fun createCenterPanel(): JComponent {
        val dialogPanel = JPanel(BorderLayout())

        val label = JLabel(MyBundle.message("mix"))
        label.preferredSize = Dimension(100, 50)
        dialogPanel.add(label, BorderLayout.CENTER)

        return dialogPanel
    }
}

class DummyDialogAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        DummyDialogWrapper(event.project).show()
    }
}