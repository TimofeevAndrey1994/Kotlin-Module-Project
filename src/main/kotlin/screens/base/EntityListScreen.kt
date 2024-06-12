package screens.base

import screens.base.interfaces.Creatable
import screens.base.interfaces.Nextable

abstract class EntityListScreen(override var title: String): Screen() {
    abstract var creator: Creatable
    abstract var nextable: Nextable
    private var itemCount = -1
    override var canExitApp: Boolean = false
    private var entityList: List<String>? = null
    abstract fun getEntityList(): List<String>?

    override fun show() {
        itemCount = 2
        entityList = getEntityList()
        println(title)
        println("0. Создать")
        entityList?.forEachIndexed { i: Int, s: String ->
            println("${i.plus(1)}. $s")
            itemCount++
        }
        println("${entityList?.count()?.plus(1) ?: 1}. Выход")
    }

    override fun handleUserInput(userInput: String): EntityScreenResult?{
        val userEnteredNumber = getIntValue(userInput, itemCount) ?: return null

        var result: EntityScreenResult? = null

        when(userEnteredNumber){
            0 -> creator.createEntity()
            (itemCount - 1) -> result = EntityScreenResult.ON_BACK
            else -> {
                nextable.onNext(userEnteredNumber - 1)
                result = EntityScreenResult.ON_NEXT
            }
        }

        return result
    }
    override fun onBeforeShow() {}
}
