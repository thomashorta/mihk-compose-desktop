package domain

import data.model.GenericForensicTileModel

data class GameModel(
    val playerModels: List<PlayerModel>,
    val presentationTimeMillis: Long,
    val forensicScientistModel: ForensicScientistModel? = null,
)

data class ForensicScientistModel(
    val causeOfDeathTile: GenericForensicTileModel,
    val locationTile: GenericForensicTileModel,
    val sceneDetailTiles: List<GenericForensicTileModel>
)
