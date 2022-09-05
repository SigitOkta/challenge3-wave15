import gameMode.GameMode
import gameMode.ModePvC
import gameMode.ModePvP
import utils.IOUtils
import utils.ValidationUtils
import kotlin.system.exitProcess

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
            3. Exit
            ======================================
            Enter menu ? (1/2/3)
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
            "3" -> {
                exitProcess(0)
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
        printGameResult(ModePvC(playerOne,playerOneName))
        printCloseMenu()
        readLine()?.let{
            closeMenu(it.lowercase())
        }
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
        printGameResult(ModePvP(playerOne,playerTwo,playerOneName,playerTwoName))
        println("======================================")
        printCloseMenu()
        readLine()?.let{
            closeMenu(it.lowercase())
        }
        println("======================================")
    }

    private fun closeMenu(menu: String) {
        when(menu){
            "y" -> {
                start()
            }
            "n" -> {
                exitProcess(0)
            }
            else -> {
                printErrorInput()
            }
        }
    }

    private fun printErrorInput() {
        println("you must choose between: Y/N")
        readLine()?.let{
            closeMenu(it.lowercase())
        }
    }

    private fun printCloseMenu() {
        println("""          
            ======================================
            Try Again ? (Y/N)
            ======================================
        """.trimIndent())
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

    private fun printGameResult(gameMode: GameMode){
        gameMode.printGameModeName()
        gameMode.printResultOfGame()
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