package screen.settings

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import data.Repository
import domain.GameModel
import domain.PlayerModel

const val MIN_PLAYERS = 3
const val MAX_PLAYERS = 11
private const val CLUE_COUNT = 4
private const val MEANS_COUNT = 4
private const val DEFAULT_TIME = 30
private const val TIME_INCREMENT = 5

class SettingsViewModel(
    private val repository: Repository = Repository()
) {
    private val playerNamesState = mutableStateListOf<String>()
    val playerNames get() = playerNamesState.toList()

    private val presentationTimeState = mutableStateOf(DEFAULT_TIME)
    val presentationTimeMillis: Long get() = presentationTimeState.value * 1000L

    init {
        repeat(MIN_PLAYERS) { playerNamesState.add("") }
    }

    fun createModel(): GameModel {
        val clues = repository.getClues().shuffled().toMutableList()
        val means = repository.getMeans().shuffled().toMutableList()

        val playerModels = playerNamesState.map {
            PlayerModel(
                name = it,
                clues = List(CLUE_COUNT) { clues.removeFirst() },
                means = List(MEANS_COUNT) { means.removeFirst() },
            )
        }

        return GameModel(playerModels, presentationTimeMillis)
    }

    fun updatePlayer(index: Int, name: String) {
        playerNamesState[index] = name
    }

    fun addPlayer() {
        playerNamesState.add("")
    }

    fun removePlayer(index: Int) {
        playerNamesState.removeAt(index)
    }

    fun incrementTime() {
        presentationTimeState.value += TIME_INCREMENT
    }

    fun decrementTime() {
        presentationTimeState.value -= TIME_INCREMENT
    }
}
