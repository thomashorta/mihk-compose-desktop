package screen.game

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.ForensicTile
import component.PlayerBoard
import component.PresentationTimer
import domain.ForensicScientistModel
import domain.GameModel
import theme.DeceptionColor
import theme.Dimen
import kotlin.math.ceil

@Composable
fun GameScreen(
    gameModel: GameModel,
    onEndGameClicked: () -> Unit
) {
    val viewModel = remember { GameViewModel(gameModel) }

    Box(
        modifier = Modifier
            .background(DeceptionColor.AppBackground)
            .fillMaxSize()
            .padding(Dimen.ScreenSpacing),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            PlayerArea(viewModel)

            ForensicScientistArea(
                viewModel,
                onEndGameClicked
            )
        }
    }
}

@Composable
private fun PlayerArea(viewModel: GameViewModel) {
    val columns = 2 // always have 2 columns
    val rows = ceil(viewModel.model.playerModels.size / 2f).toInt()
    Column(
        verticalArrangement = Arrangement.spacedBy(
            Dimen.ScreenSpacing,
            Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        repeat(rows) { row ->
            Row(
                Modifier.weight(1f, false).fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    Dimen.ScreenSpacing,
                    Alignment.CenterHorizontally
                )
            ) {
                val playerCount = viewModel.model.playerModels.size
                val neededColumns = if (row == rows - 1) playerCount - row * columns else columns
                val horizontalSpacersWeight = 1f * (columns - neededColumns) / columns

                if (horizontalSpacersWeight > 0f) {
                    Spacer(Modifier.weight(horizontalSpacersWeight))
                }

                repeat(neededColumns) { column ->
                    val index = row * columns + column
                    PlayerBoard(
                        playerModel = viewModel.model.playerModels[index],
                        onBadgeClicked = { viewModel.toggleBadge(index) },
                        modifier = Modifier.weight(1f, false)
                    )
                }

                if (horizontalSpacersWeight > 0f) {
                    Spacer(Modifier.weight(horizontalSpacersWeight))
                }
            }
        }
    }
}

@Composable
private fun ForensicScientistArea(
    viewModel: GameViewModel,
    onEndGameClicked: () -> Unit = {},
    onReplayClicked: () -> Unit = {}
) {
    val forensicScientistModel = viewModel.model.forensicScientistModel
    if (forensicScientistModel == null) {
        LocationTileSelection(viewModel)
    } else {
        ForensicScientistRow(
            forensicScientistModel,
            viewModel,
            onEndGameClicked,
            onReplayClicked
        )
    }
}

@Composable
private fun LocationTileSelection(
    viewModel: GameViewModel
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        viewModel.getAllLocationTiles().forEach { locationTile ->
            ForensicTile(
                locationTile,
                color = DeceptionColor.LocationCard,
                modifier = Modifier
                    .widthIn(max = Dimen.ForensicTileWidth)
                    .weight(1f)
                    .clickable { viewModel.selectLocationTile(locationTile) }
            )
        }
    }
}

@Composable
private fun ForensicScientistRow(
    forensicScientistModel: ForensicScientistModel,
    viewModel: GameViewModel,
    onEndGameClicked: () -> Unit = {},
    onReplayClicked: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier.height(IntrinsicSize.Min)
    ) {
        val tileModifier = Modifier
            .fillMaxHeight()
            .widthIn(max = Dimen.ForensicTileWidth)
            .weight(1f)

        ForensicTile(
            forensicScientistModel.locationTile,
            color = DeceptionColor.LocationCard,
            modifier = tileModifier,
        )

        ForensicTile(
            forensicScientistModel.causeOfDeathTile,
            color = DeceptionColor.CauseOfDeathCard,
            modifier = tileModifier,
        )

        forensicScientistModel.sceneDetailTiles.forEach { sceneDetail ->
            ForensicTile(
                sceneDetail,
                color = DeceptionColor.SceneDetailCard,
                showRemoveButton = true,
                onClickRemove = { viewModel.swapSceneDetailTile(sceneDetail) },
                modifier = tileModifier,
            )
        }

        if (forensicScientistModel.sceneDetailTiles.size <= SCENE_DETAILS_COUNT) {
            Box(
                modifier = tileModifier
                    .border(2.dp, DeceptionColor.OnSurface, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    PresentationTimer(
                        viewModel.model.presentationTimeMillis,
                    )

                    /* TODO figure out how to restart the board
                    Button(
                        onClick = { onReplayClicked() },
                    ) {
                        Text("REPLAY")
                    }
                     */

                    Button(
                        onClick = { onEndGameClicked() },
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text("END GAME")
                    }
                }
            }
        }
    }
}
