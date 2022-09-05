class App {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            App().start()
        }
    }

    fun start() {
        printHeader()
        readLine()?.let{
            openMenu(it)
        }
    }

    private fun printHeader() {
        println("""
            ======================================
            Console Rock, Scissor, paper game
            ======================================
            1. Play with Player
            2. Play with Computer
            ======================================
            Enter menu ? (1/2)
            ======================================
        """.trimIndent())
    }

    private fun openMenu(menu: String) {
        when(menu){
            "1" -> {
                openMenuPvP()
            }
            "2" -> {
                openMenuPvC()
            }
            else -> {
                println("No menu matches")
                start()
            }
        }
    }

    private fun openMenuPvC() {
        TODO("Not yet implemented")
    }

    private fun openMenuPvP() {
        TODO("Not yet implemented")
    }
}