package screen

import model.Archive

class MainScreen(
    archives: MutableList<Archive>,
    back: Screen<*>?
) : MenuScreen<MutableList<Archive>>(archives, back) {
    override val content: String = "Список архивов:"
    override val options: Map<MenuAction, String> = mapOf(
        MenuAction.CREATE to "Создать архив",
        MenuAction.CHOOSE to "Это мой уже созданный архив",
        MenuAction.RETURN to "Выход"
    )

    override fun getCreateScreen(
        entity: MutableList<Archive>,
        back: Screen<*>?
    ): Screen<*>? {
        return ArchiveCreateScreen(entity, this)
    }

    override fun getChooseScreen(
        entity: MutableList<Archive>,
        back: Screen<*>?
    ): Screen<*>? {
        return ArchiveSelectScreen(entity, this)
    }
}
