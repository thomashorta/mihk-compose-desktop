// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import screen.Screen
import screen.game.GameScreen
import screen.settings.SettingsScreen
import theme.DeceptionTheme

@Composable
@Preview
fun App() {
    DeceptionTheme {
        var screen by remember { mutableStateOf<Screen>(Screen.Settings) }
        when (val currentScreen = screen) {
            Screen.Settings -> SettingsScreen(
                onStartGameClick = { model -> screen = Screen.Game(model) }
            )
            is Screen.Game -> GameScreen(
                currentScreen.model,
                onEndGameClicked = { screen = Screen.Settings }
            )
        }
    }
}

fun main() = application {
    val icon = painterResource("icons/icon.png")
    Window(
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(),
        title = "Deception: Murder in Hong Kong",
        icon = icon,
    ) {
        App()
    }
}
