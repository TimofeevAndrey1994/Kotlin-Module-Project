package screens

import screens.base.EntityListScreen
import screens.base.interfaces.Creatable
import screens.base.interfaces.Nextable
import viewModel.ViewModel

class NoteListListScreen : EntityListScreen("Выбор заметки"){
    override var nextable: Nextable = Nextable {index ->
        ViewModel.setCurrentNote(index)
    }
    override var creator: Creatable = Creatable {
        println("Введите название заметки")
        val noteTitle = getStringValue()
        println("Введите текст заметки")
        val noteText = getStringValue()
        ViewModel.addNewNote(noteTitle, noteText)
    }
    override fun onBeforeShow() {
        title = "Архив - \"${ViewModel.getCurrentArchive()}\". Выбор заметки:"
    }
    override fun getEntityList(): List<String>? = ViewModel.getAllNotesFromCurrentArchive()
}