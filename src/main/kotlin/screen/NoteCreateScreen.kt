package screen

import model.Note

class NoteCreateScreen(
    notes: MutableList<Note>,
    back: Screen<*>?
) : Screen<MutableList<Note>>(notes, back) {
    override fun render(): Screen<*>? {
        val name = readString("имя заметки", data.map { it.name }.toSet())
        val text = readString("текст заметки", emptySet())
        data.add(Note(name, text))
        return prevScreen
    }
}
