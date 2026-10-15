package screen

import model.Archive

class ArchiveSelectScreen(
    archives: MutableList<Archive>,
    back: Screen<*>?
) : ChoiceScreen<Archive>(archives, back) {
    override val entityNameRu: String = "архив"

    override fun getScreenForChoice(entity: Archive): Screen<*>? {
        return ArchiveMainScreen(entity.notes, this)
    }
}
