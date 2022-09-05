package gameMode

abstract class GameMode {
    var gameModeName : String? = null
    open var playerOne : String? = null
    open var playerTwo : String? = null
    open var playerOneName : String? = null
    open var playerTwoName : String? = null

    private val a = "rock"
    private val b = "scissor"
    private val c = "paper"

    fun printGameModeName() {
        println("GameMode : $gameModeName")
    }

    fun printResultOfGame() {
        if (playerOne == playerTwo){
            printPlayerChoose()
            println(" Draw !!!!!")
        } else if (
            playerOne == a && playerTwo == b ||
            playerOne == b && playerTwo == c ||
            playerOne == c && playerTwo == a
        ){
            printPlayerChoose()
            println("Congrats $playerOneName Win !!!!")
        } else {
            printPlayerChoose()
            println("Congrats $playerTwoName Win !!!!")
        }
    }

    private fun printPlayerChoose() {
        println("$playerOneName : $playerOne")
        println("$playerTwoName : $playerTwo")
    }
}