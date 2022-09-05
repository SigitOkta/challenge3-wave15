package utils

object IOUtils {
    fun readString(): String {
        return readLine()?.lowercase().orEmpty()
    }
}