package screenNavigator

import screens.base.EntityScreenResult
import screens.base.Screen

class ScreenNavigator(vararg screens: Screen) {
    private val screenList: List<Screen> = screens.toList()

    fun start(){
        var index = 0
        var screen = screenList[index]
        while (true) {
            screen.onBeforeShow()
            screen.show()
            val screenResult = screen.askUserInput()
            when (screenResult) {
                EntityScreenResult.ON_NEXT -> {
                    if ((index + 1) > (screenList.size - 1)) continue
                    screen = screenList[++index]
                    continue
                }
                EntityScreenResult.ON_BACK -> {
                    if ((screenList.size - 1) < 0) continue
                    if (screen.canExitApp)  break
                    else {
                        screen = screenList[--index]
                        continue
                    }
                }
                null -> continue
            }
        }
    }

}