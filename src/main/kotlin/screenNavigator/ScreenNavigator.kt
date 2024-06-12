package screenNavigator

import screens.base.EntityScreenResult
import screens.base.Screen
import java.util.Scanner

class ScreenNavigator {
    private val scanner = Scanner(System.`in`)
    private val screens: MutableList<Screen> = mutableListOf()
    fun start(){
        var index = 0
        var screen = screens[index]
        while (true) {
            screen.onBeforeShow()
            screen.show()
            val userInput = scanner.nextLine()
            val screenResult = screen.handleUserInput(userInput)
            when (screenResult) {
                EntityScreenResult.ON_NEXT -> {
                    if ((index + 1) > (screens.size - 1)) continue
                    screen = screens[++index]
                    continue
                }
                EntityScreenResult.ON_BACK -> {
                    if ((screens.size - 1) < 0) continue
                    if (screen.canExitApp)  break
                    else {
                        screen = screens[--index]
                        continue
                    }
                }
                null -> continue
            }
        }
    }

    fun addScreen(screen: Screen){
        screens.add(screen)
    }
}