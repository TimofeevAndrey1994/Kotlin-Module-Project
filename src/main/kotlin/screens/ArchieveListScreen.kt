package screens

import screens.base.EntityListScreen
import screens.base.interfaces.Creatable
import utils.getStringValue
import viewModel.ViewModel
import java.util.function.Consumer


class ArchiveListListScreen : EntityListScreen("Выбор архива"){

    override var onNext: Consumer<Int> = Consumer<Int> { ind ->  ViewModel.setCurrentArchive(ind) }

    override var canExitApp = true

    override var creator: Creatable = Creatable {
        println("Введите название архива")
        val archName = scanner.getStringValue()
        if (!ViewModel.addNewArchive(archName)){
            println("Архив с именем уже существует!")
        }
    }

    override fun getEntityList(): List<String> = ViewModel.getAllArchives()
}