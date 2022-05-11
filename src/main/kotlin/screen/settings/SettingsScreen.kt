package screen.settings

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.GameModel
import theme.DeceptionColor
import theme.Dimen
import util.formatTimer
import java.text.SimpleDateFormat
import java.util.*

private val TimerFontSize = 28.sp

@Composable
fun SettingsScreen(
    onStartGameClick: (GameModel) -> Unit
) {
    val viewModel = remember { SettingsViewModel() }
    Box(
        modifier = Modifier
            .background(DeceptionColor.AppBackground)
            .fillMaxSize()
            .padding(Dimen.ScreenSpacing),
        contentAlignment = Alignment.Center,
    ) {
        val shape = RoundedCornerShape(8.dp)
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .background(DeceptionColor.Surface, shape)
                .padding(16.dp)
                .wrapContentSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PlayerSection(viewModel)

            Spacer(Modifier.height(16.dp))

            TimerSection(viewModel)

            Spacer(Modifier.height(16.dp))

            Button(onClick = { onStartGameClick(viewModel.createModel()) }) {
                Text("START GAME")
            }
        }
    }
}

@Composable
private fun PlayerSection(viewModel: SettingsViewModel) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Players", color = DeceptionColor.OnSurface)

        Spacer(Modifier.height(8.dp))

        viewModel.playerNames.forEachIndexed { index, name ->
            PlayerField(
                name,
                label = "Player ${index + 1}",
                onNameChange = { newName -> viewModel.updatePlayer(index, newName) },
                showRemoveButton = index >= MIN_PLAYERS,
                onClickRemove = { viewModel.removePlayer(index) }
            )

            if (index < viewModel.playerNames.lastIndex) Spacer(Modifier.height(8.dp))
        }

        if (viewModel.playerNames.size < MAX_PLAYERS) {
            Spacer(Modifier.height(4.dp))

            TextButton(onClick = { viewModel.addPlayer() }) {
                Text("ADD PLAYER")
            }
        }
    }
}

@Composable
private fun PlayerField(
    name: String,
    label: String,
    onNameChange: (String) -> Unit,
    showRemoveButton: Boolean,
    onClickRemove: () -> Unit,
) {
    Box {
        TextField(
            name,
            label = { Text(label) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = DeceptionColor.OnSurface,
                unfocusedLabelColor = DeceptionColor.TextFieldLabel,
            ),
            onValueChange = onNameChange
        )
        if (showRemoveButton) {
            IconButton(
                onClick = onClickRemove,
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(Icons.Filled.Close, "delete", tint = DeceptionColor.OnSurface)
            }
        }
    }
}

@Composable
private fun TimerSection(viewModel: SettingsViewModel) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Presentation Timer", color = DeceptionColor.OnSurface)

        Spacer(Modifier.height(4.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(onClick = { viewModel.decrementTime() }) {
                Text("-")
            }

            Text(
                formatTimer(viewModel.presentationTimeMillis),
                fontSize = TimerFontSize,
                color = DeceptionColor.OnSurface,
            )

            Button(onClick = { viewModel.incrementTime() }) {
                Text("+")
            }
        }
    }
}
