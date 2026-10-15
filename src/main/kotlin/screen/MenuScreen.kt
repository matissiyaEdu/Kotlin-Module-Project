package screen

abstract class MenuScreen<T>(
    data: T,
    back: Screen<*>?
) : Screen<T>(data, back) {
    abstract val content: String;
    abstract val options: Map<MenuAction, String>
    abstract fun getCreateScreen(entity: T, back: Screen<*>?): Screen<*>?
    abstract fun getChooseScreen(entity: T, back: Screen<*>?): Screen<*>?

    override fun render(): Screen<*>? {
        println(content)
        options.forEach { (action, translation) -> println("${action.ordinal}. $translation") }

        val command: Int = readNumericCommand() {
            !options.filter { item -> item.key.ordinal == it }.isEmpty()
        }

        return when (command) {
            0 -> getCreateScreen(data, this)
            1 -> getChooseScreen(data, this)
            2 -> prevScreen
            else -> this
        }
    }
}
