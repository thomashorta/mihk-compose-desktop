package screen

import domain.GameModel

sealed interface Screen {
    object Settings : Screen
    data class Game(val model: GameModel) : Screen
}