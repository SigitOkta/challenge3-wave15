package gameMode

class ModePvC(
    override var playerOne: String?,
    override var playerOneName: String?) : GameMode() {
    init {
        gameModeName = "Player Vs Computer (PVC)"
    }

    override var playerTwo: String? = randomChoice()
    override var playerTwoName: String? = "Computer"
    private fun randomChoice(): String {
        return arrayOf("rock", "scissor", "paper").random()
    }
}