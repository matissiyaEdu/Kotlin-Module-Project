package screen

import NoteProgram.Companion.input

abstract class Screen<T>(
    protected val data: T,
    protected val prevScreen: Screen<*>?
) {
    abstract fun render(): Screen<*>?

    protected fun readNumericCommand(expectedPredicate: (Int) -> Boolean): Int {
        var command: Int? = null;
        while (command == null) {
            val inputValue = input.nextLine().toIntOrNull()
            if (inputValue == null) {
                println("Необходимо ввести число, повторите ввод")
                continue
            }
            if (!expectedPredicate.invoke(inputValue)) {
                println("Такой команды нет, повторите ввод")
                continue
            }
            command = inputValue
        }
        return command
    }

    protected fun readString(valueName: String, existedValues: Set<String>): String {
        println("Введите $valueName:")
        var result: String? = null
        while (result == null) {
            val inputValue = input.nextLine()
            if (inputValue.isNullOrBlank()) {
                println("Значение не может быть пустым, введите заново:")
                continue
            }
            if (existedValues.contains(inputValue)) {
                println("Значение должно быть уникальным, введите заново:")
                continue
            }
            result = inputValue
        }
        return result
    }
}
