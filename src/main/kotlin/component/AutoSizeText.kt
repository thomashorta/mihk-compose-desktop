package component

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.drawWithContent

@Composable
fun AutoSizeText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 1,
    initialStyle: TextStyle = LocalTextStyle.current,
    onAutoSizeCalculated: (TextStyle) -> Unit = {},
) {
    var textStyle by remember { mutableStateOf(initialStyle) }
    var readyToDraw by remember { mutableStateOf(false) }

    Text(
        text = text,
        style = textStyle,
        maxLines = maxLines,
        softWrap = false,
        modifier = modifier.drawWithContent {
            if (readyToDraw) drawContent()
        },
        onTextLayout = { textLayoutResult ->
            if (textLayoutResult.didOverflowWidth) {
                textStyle = textStyle.copy(fontSize = textStyle.fontSize * 0.9)
            } else {
                readyToDraw = true
                onAutoSizeCalculated(textStyle)
            }
        }
    )
}
