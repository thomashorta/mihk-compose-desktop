package data.source

import data.model.EventTileModel
import data.model.GenericForensicTileModel

interface DataSource {
    val clues: List<String>
    val means: List<String>
    val causeOfDeath: GenericForensicTileModel
    val locations: List<GenericForensicTileModel>
    val sceneDetails: List<GenericForensicTileModel>
    val events: List<EventTileModel>
}