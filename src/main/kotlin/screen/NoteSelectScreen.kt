package screen

import model.Note

class NoteSelectScreen(
    notes: MutableList<Note>,
    back: Screen<*>?
) : ChoiceScreen<Note>(notes, back) {
    override val entityNameRu: String = "заметку"

    override fun getScreenForChoice(entity: Note): Screen<*>? {
        return NoteViewScreen(entity, this)
    }
}
