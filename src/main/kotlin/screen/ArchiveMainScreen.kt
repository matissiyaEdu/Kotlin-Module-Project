package screen

import model.Note

class ArchiveMainScreen(
    notes: MutableList<Note>,
    back: Screen<*>?
) : MenuScreen<MutableList<Note>>(notes, back) {
    override val content: String = "Список заметок:"
    override val options: Map<MenuAction, String> = mapOf(
        MenuAction.CREATE to "Создать заметку",
        MenuAction.CHOOSE to "Открыть существующую заметку",
        MenuAction.RETURN to "Назад"
    )

    override fun getCreateScreen(
        entity: MutableList<Note>,
        back: Screen<*>?
    ): Screen<*>? {
        return NoteCreateScreen(entity, this)
    }

    override fun getChooseScreen(
        entity: MutableList<Note>,
        back: Screen<*>?
    ): Screen<*>? {
        return NoteSelectScreen(entity, this)
    }
}
