package screen

import model.Note

class NoteViewScreen(
    note: Note,
    back: Screen<*>?
) : MenuScreen<Note>(note, back) {

    override val content: String = """
        Содержание заметки '${data.name}':
        ${data.text}
    """.trimIndent()
    override val options: Map<MenuAction, String> = mapOf(
        MenuAction.RETURN to "Назад"
    )

    override fun getCreateScreen(entity: Note, back: Screen<*>?): Screen<*>? {
        return back
    }

    override fun getChooseScreen(entity: Note, back: Screen<*>?): Screen<*>? {
        return back
    }
}
