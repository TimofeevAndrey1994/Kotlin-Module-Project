package utils

import java.util.Scanner

fun Scanner.getStringValue(): String{
    var result: String
    while (true){
        result = this.nextLine()
        if (result.trim().isNotEmpty()) break
    }
    return result
}

fun Scanner.getIntValue(itemCount: Int): Int?{
    val userInput = this.nextLine()
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