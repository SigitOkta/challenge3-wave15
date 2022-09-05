import utils.IOUtils
import utils.ValidationUtils

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
        val(playerOne,playerOneName) = inputPlayerOne()
        println("======================================")
        println("$playerOneName : $playerOne")
        println("======================================")
    }


    private fun openMenuPvP() {
        val(playerOne,playerOneName) = inputPlayerOne()
        println("--------------------------------------")
        println("Player 2's Turn!!! ")
        println("Input Player 2 Name :")
        val playerTwoName = IOUtils.readString()
        println("Player 2 choose: Rock, Scissor, Paper")
        val playerTwo = inputPlayerChoice()
        println("======================================")
        println("""
            "$playerOneName : $playerOne"
            "$playerTwoName : $playerTwo"
        """.trimIndent())
        println("======================================")
    }

    private fun inputPlayerOne(): Pair<String, String> {
        println("--------------------------------------")
        println("Player 1's Turn!!! ")
        println("Input Player 1 Name :")
        val playerOneName = IOUtils.readString()
        println("Player 1 choose: Rock, Scissor, Paper")
        val playerOne = inputPlayerChoice()
        return Pair(playerOne,playerOneName)
    }

    private fun inputPlayerChoice(): String {
        var choice = ""
        while (choice == ""){
            println("Choice : ")
            val tempChoice = IOUtils.readString()
            if (ValidationUtils.checkChooseIfValid(tempChoice)) {
                choice = tempChoice
            } else {
                println("--------------------------------")
                println("you must choose between: Rock, Scissor, Paper")
                println("--------------------------------")
            }
        }
        return choice
    }
}