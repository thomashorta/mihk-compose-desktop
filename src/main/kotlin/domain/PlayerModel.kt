package domain

data class PlayerModel(
    val name: String,
    val clues: List<PlayerCardModel>,
    val means: List<PlayerCardModel>,
    val hasBadge: Boolean = true,
)
