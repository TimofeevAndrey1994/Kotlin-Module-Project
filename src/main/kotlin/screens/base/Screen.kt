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
    abstract fun handleUserInput(userInput: String): EntityScreenResult?

    /**
        Вызывается перед показом экрана
     */
    abstract fun onBeforeShow()

    protected fun getIntValue(userInput: String, itemCount: Int): Int?{
        val userEnteredNumber: Int
        try {
            userEnteredNumber = userInput.toInt()
        }
        catch(_: NumberFormatException) {
            println("Некорректное значение. Попробуйте еще раз!")
            return null
        }

        if ((userEnteredNumber < 0) or ((userEnteredNumber + 1) > itemCount)){
            println("Некорректное значение. Попробуйте еще раз!")
            return null
        }
        return userEnteredNumber
    }

    protected fun getStringValue(): String{
        var result: String
        while (true){
            result = scanner.nextLine()
            if (result.trim().isNotEmpty()) break
        }
        return result
    }
}

enum class EntityScreenResult{
    ON_NEXT,
    ON_BACK
}