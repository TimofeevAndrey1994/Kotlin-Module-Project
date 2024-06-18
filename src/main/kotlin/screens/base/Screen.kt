package screens.base

import java.util.Scanner

abstract class Screen {
    protected val scanner = Scanner(System.`in`)

    protected abstract var title: String
    /**
        Задает поведение экрана при нажатии на кнопку "Выход"
     */
    abstract var canExitApp: Boolean

    /**
        Отображает экран
     */
    abstract fun show()

    /**
        Обрабатывает пользовательский ввод
     */
    abstract fun askUserInput(): EntityScreenResult?

    /**
        Вызывается перед показом экрана
     */
    abstract fun onBeforeShow()

}

enum class EntityScreenResult{
    ON_NEXT,
    ON_BACK
}