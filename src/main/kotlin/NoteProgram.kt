import model.Archive
import screen.MainScreen
import screen.Screen
import java.util.Scanner

class NoteProgram {

    private val archives: MutableList<Archive> = mutableListOf()

    companion object {
        val input = Scanner(System.`in`)
    }

    fun start() {
        println("Hello!")

        var initScreen: Screen<*>? = MainScreen(archives, null)
        while (initScreen != null) {
            initScreen = initScreen.render()
        }

        println("Bye!")
    }
}
