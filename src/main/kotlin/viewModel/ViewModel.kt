package viewModel

import model.Note

object ViewModel {
    private val archive: MutableMap<String, MutableList<Note>?> = mutableMapOf()
    private var currentArchive: String = ""
    private var currentNote: Note? = null

    fun addNewArchive(archiveTitle: String): Boolean{
        if (archive.contains(archiveTitle)) return false
        archive[archiveTitle] = null
        return true
    }

    fun setCurrentArchive(index: Int){
        currentArchive = getAllArchives()[index]
    }

    fun setCurrentNote(index: Int){
        currentNote = archive[currentArchive]?.toList()?.get(index)
    }

    fun getCurrentNote() = currentNote

    fun getCurrentArchive() = currentArchive

    fun addNewNote(noteTitle: String, noteText: String): Boolean{
        if (!archive.contains(currentArchive)) return false
        val note = Note(noteTitle, noteText)
        val noteList = if (archive[currentArchive] == null) mutableListOf() else archive[currentArchive]
        noteList?.add(note)
        archive[currentArchive] = noteList
        return true
    }

    fun getAllArchives(): List<String> = archive.keys.toList()

    fun getAllNotesFromCurrentArchive(): List<String>? {
       return archive[currentArchive]?.map {
            it.title
        }
    }

}