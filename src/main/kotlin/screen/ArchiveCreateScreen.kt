package screen

import model.Archive

class ArchiveCreateScreen(
    archives: MutableList<Archive>,
    back: Screen<*>?
) : Screen<MutableList<Archive>>(archives, back) {

    override fun render(): Screen<*>? {
        val name = readString("имя архива", data.map { it.name }.toSet())
        data.add(Archive(name))
        return prevScreen
    }
}
