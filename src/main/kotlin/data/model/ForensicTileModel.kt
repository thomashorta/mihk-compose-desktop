package data.model

sealed interface ForensicTileModel

/**
 * Cause of death, location and the rest of scene tiles are represented by this class.
 */
data class GenericForensicTileModel(
    val title: String,
    val options: List<String>,
) : ForensicTileModel

data class EventTileModel(
    val title: String,
    val effect: String,
) : ForensicTileModel
