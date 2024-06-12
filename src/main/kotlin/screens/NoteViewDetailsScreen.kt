package screens

import screens.base.EntityScreenResult
import screens.base.Screen
import viewModel.ViewModel

class NoteViewDetailsScreen(override var title: String = ""): Screen() {
    override var canExitApp = false
    override fun onBeforeShow() {
        title = "Заметка - \"${ViewModel.getCurrentNote()?.title}\""
    }
    override fun show(){
        println(title)
        println()
        println("  ${ViewModel.getCurrentNote()?.text}")
        println()
        println("0. Выход")
    }

    override fun handleUserInput(userInput: String): EntityScreenResult? {
        if (getIntValue(userInput, 1) == null)  return null

        return EntityScreenResult.ON_BACK
    }

}