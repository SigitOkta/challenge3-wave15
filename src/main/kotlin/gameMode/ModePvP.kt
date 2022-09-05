package gameMode

class ModePvP(
    override var playerOne: String?,
    override var playerTwo: String?,
    override var playerOneName: String?,
    override var playerTwoName: String?
) : GameMode() {
    init {
        gameModeName = "Player Vs Player (PVP)"
    }
}