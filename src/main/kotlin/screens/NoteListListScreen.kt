package screens

import screens.base.EntityListScreen
import screens.base.interfaces.Creatable
import utils.getStringValue
import viewModel.ViewModel
import java.util.function.Consumer

class NoteListListScreen : EntityListScreen("Выбор заметки"){

    override var onNext: Consumer<Int> = Consumer<Int> {ind -> ViewModel.setCurrentNote(ind)}

    override var creator: Creatable = Creatable {
        println("Введите название заметки")
        val noteTitle = scanner.getStringValue()
        println("Введите текст заметки")
        val noteText = scanner.getStringValue()
        ViewModel.addNewNote(noteTitle, noteText)
    }
    override fun onBeforeShow() {
        title = "Архив - \"${ViewModel.getCurrentArchive()}\". Выбор заметки:"
    }
    override fun getEntityList(): List<String>? = ViewModel.getAllNotesFromCurrentArchive()
}