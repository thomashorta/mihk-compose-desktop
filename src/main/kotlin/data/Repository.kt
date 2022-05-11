package data

import data.model.GenericForensicTileModel
import data.source.DataSource
import data.source.HardcodedDataSource
import domain.PlayerCardModel

class Repository(
    private val dataSource: DataSource = HardcodedDataSource()
) {
    fun getClues(): List<PlayerCardModel> = dataSource.clues.map { PlayerCardModel(it) }

    fun getMeans(): List<PlayerCardModel> = dataSource.means.map { PlayerCardModel(it) }

    fun getCauseOfDeathTile(): GenericForensicTileModel = dataSource.causeOfDeath

    fun getLocationTiles(): List<GenericForensicTileModel> = dataSource.locations

    fun getSceneDetails(): List<GenericForensicTileModel> = dataSource.sceneDetails
}
