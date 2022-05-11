package component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import theme.DeceptionColor
import util.formatTimer

@Composable
fun PresentationTimer(
    timeMillis: Long,
    modifier: Modifier = Modifier,
    onTimerEnd: () -> Unit = {},
) {
    val controller = remember { TimerController(timeMillis, onTimerEnd) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            controller.formattedTime,
            fontSize = 32.sp,
            color = DeceptionColor.OnSurface,
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            fun isRunning() = controller.state == TimerState.RUNNING
            Button(
                onClick = { if (isRunning()) controller.pause() else controller.start() },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    if (isRunning()) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = if (isRunning()) "pause" else "play",
                )
            }

            Button(
                onClick = { controller.stop() },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    Icons.Default.Stop,
                    contentDescription = "stop"
                )
            }
        }
    }
}

private const val TIMER_TICK = 250L

class TimerController(
    private val timeMillis: Long,
    private val onTimerEnd: () -> Unit = {},
) {
    private val currentTimeState = mutableStateOf(timeMillis)
    val formattedTime: String get() = formatTimer(currentTimeState.value)

    private val scope = CoroutineScope(Dispatchers.Main)
    private var timerJob: Job? = null

    private var lastTick: Long = 0L

    private val timerState = mutableStateOf(TimerState.STOPPED)
    val state get() = timerState.value

    private fun updateState() {
        timerState.value = if (timerJob?.isActive == true) {
            TimerState.RUNNING
        } else if (currentTimeState.value < timeMillis) {
            TimerState.PAUSED
        } else {
            TimerState.STOPPED
        }
    }

    fun start() {
        timerJob = scope.launch {
            lastTick = System.currentTimeMillis()
            while (currentTimeState.value > 0L) {
                delay(TIMER_TICK)
                val now = System.currentTimeMillis()
                currentTimeState.value -= now - lastTick
                lastTick = now
            }
            onTimerEnd()
        }
        updateState()
    }

    fun stop() {
        timerJob?.cancel()
        timerJob = null

        currentTimeState.value = timeMillis
        updateState()
    }

    fun pause() {
        timerJob?.cancel()
        timerJob = null
        updateState()
    }
}

enum class TimerState {
    RUNNING, PAUSED, STOPPED
}
