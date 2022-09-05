package utils

object IOUtils {
    fun readString(default: String = "Player"): String {
        return readLine() ?: default
    }
}