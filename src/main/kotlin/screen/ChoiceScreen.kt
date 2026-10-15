package screen

import model.File

abstract class ChoiceScreen<T : File>(
    data: MutableList<T>,
    back: Screen<*>?
) : Screen<MutableList<T>>(data, back) {
    abstract val entityNameRu: String;

    abstract fun getScreenForChoice(entity: T): Screen<*>?

    override fun render(): Screen<*>? {
        println("Выберите %s:".format(entityNameRu))
        data.forEachIndexed { index, item -> println("%d. %s".format(index, item.name)) }
        println("%d. Назад".format(data.size))

        val command: Int = readNumericCommand() {
            it >= 0 && it < (data.size + 1)
        }

        if (command == data.size) {
            return prevScreen
        }

        val entity = data[command]
        return getScreenForChoice(entity)
    }
}
