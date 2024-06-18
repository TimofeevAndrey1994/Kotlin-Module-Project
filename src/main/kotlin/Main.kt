import screenNavigator.ScreenNavigator
import screens.ArchiveListListScreen
import screens.NoteListListScreen
import screens.NoteViewDetailsScreen

fun main() {
    //--- Добавляем экраны в требуемой очередности
    val screenNavigator = ScreenNavigator(ArchiveListListScreen(), NoteListListScreen(), NoteViewDetailsScreen())
    //--- Запускаем приложение
    screenNavigator.start()
}