import screenNavigator.ScreenNavigator
import screens.ArchiveListListScreen
import screens.NoteListListScreen
import screens.NoteViewDetailsScreen

fun main() {
    val screenNavigator = ScreenNavigator()
    //--- Добавляем экраны в требуемой очередности
    screenNavigator.addScreen(ArchiveListListScreen())
    screenNavigator.addScreen(NoteListListScreen())
    screenNavigator.addScreen(NoteViewDetailsScreen())
    //--- Запускаем приложение
    screenNavigator.start()
}