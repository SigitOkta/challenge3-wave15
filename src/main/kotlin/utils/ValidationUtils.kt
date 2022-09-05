package utils

object ValidationUtils {
    fun checkChooseIfValid(choose: String): Boolean {
        return choose in arrayOf("rock", "scissor", "paper")
    }
}
