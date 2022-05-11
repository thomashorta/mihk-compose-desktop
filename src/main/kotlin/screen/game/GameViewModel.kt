package screen.game

import androidx.compose.runtime.mutableStateOf
import data.Repository
import data.model.GenericForensicTileModel
import domain.ForensicScientistModel
import domain.GameModel

const val SCENE_DETAILS_COUNT = 4

class GameViewModel(
    gameModel: GameModel,
    private val repository: Repository = Repository()
) {
    private val modelState = mutableStateOf(gameModel)
    val model: GameModel get() = modelState.value

    private val availableSceneDetails = repository.getSceneDetails().shuffled().toMutableList()

    fun toggleBadge(playerIndex: Int) {
        modelState.value = model.copy(
            playerModels = model.playerModels.mapIndexed { index, player ->
                if (index == playerIndex) {
                    player.copy(hasBadge = !player.hasBadge)
                } else player
            }
        )
    }

    fun getAllLocationTiles(): List<GenericForensicTileModel> = repository.getLocationTiles()

    fun selectLocationTile(tile: GenericForensicTileModel) {
        modelState.value = model.copy(
            forensicScientistModel = ForensicScientistModel(
                causeOfDeathTile = repository.getCauseOfDeathTile(),
                locationTile = tile,
                sceneDetailTiles = List(SCENE_DETAILS_COUNT) {
                    availableSceneDetails.removeFirst()
                },
            )
        )
    }

    fun drawSceneDetailTile() {
        val currentForensicScientist = model.forensicScientistModel ?: return
        val newDetails = currentForensicScientist.sceneDetailTiles + availableSceneDetails.removeFirst()

        modelState.value = model.copy(
            forensicScientistModel = currentForensicScientist.copy(
                sceneDetailTiles = newDetails
            )
        )
    }

    fun removeSceneDetailTile(tile: GenericForensicTileModel) {
        val currentForensicScientist = model.forensicScientistModel ?: return
        val newDetails = currentForensicScientist.sceneDetailTiles - tile

        modelState.value = model.copy(
            forensicScientistModel = currentForensicScientist.copy(
                sceneDetailTiles = newDetails
            )
        )
    }

    fun swapSceneDetailTile(oldTile: GenericForensicTileModel) {
        val currentForensicScientist = model.forensicScientistModel ?: return

        val newTile = availableSceneDetails.removeFirst()
        val index = currentForensicScientist.sceneDetailTiles.indexOf(oldTile)

        val newSceneDetails = currentForensicScientist.sceneDetailTiles.toMutableList()
        newSceneDetails[index] = newTile

        modelState.value = model.copy(
            forensicScientistModel = currentForensicScientist.copy(
                sceneDetailTiles = newSceneDetails
            )
        )
    }
}
