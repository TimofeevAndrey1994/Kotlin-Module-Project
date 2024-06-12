package screens

import screens.base.EntityListScreen
import screens.base.interfaces.Creatable
import screens.base.interfaces.Nextable
import viewModel.ViewModel

class ArchiveListListScreen : EntityListScreen("Выбор архива"){
    override var canExitApp = true

    override var nextable: Nextable = Nextable {index ->
        ViewModel.setCurrentArchive(index)
    }
    override var creator: Creatable = Creatable {
        println("Введите название архива")
        val archName = getStringValue()
        if (!ViewModel.addNewArchive(archName)){
            println("Архив с именем уже существует!")
        }
    }

    override fun getEntityList(): List<String> = ViewModel.getAllArchives()
}