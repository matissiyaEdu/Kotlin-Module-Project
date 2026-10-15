package model

class Note(override val name: String, val text: String) : File() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
