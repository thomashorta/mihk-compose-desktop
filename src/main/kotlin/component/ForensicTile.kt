package component

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.GenericForensicTileModel
import theme.DeceptionColor
import theme.DeceptionTheme

private val TitleTextStyle = TextStyle(
    fontSize = 14.sp,
    fontWeight = FontWeight.W600,
    letterSpacing = 2.sp,
)

private val OptionTextStyle = TextStyle(
    fontSize = 14.sp,
)

@Composable
fun ForensicTile(
    model: GenericForensicTileModel,
    color: Color,
    modifier: Modifier = Modifier,
    showRemoveButton: Boolean = false,
    onClickRemove: () -> Unit = {},
) {
    var selectedOption by remember { mutableStateOf<String?>(null) }
    val shape = RoundedCornerShape(8.dp)

    Column(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .background(DeceptionColor.Surface, shape)
            .border(2.dp, color, shape)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            Modifier.weight(1f)
        ) {
            Text(
                model.title.uppercase(),
                style = TitleTextStyle,
                color = color,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().align(Alignment.Center)
            )

            if (showRemoveButton) {
                IconButton(
                    onClick = {
                        // TODO ideally we should hoist the selection state to the model
                        selectedOption = null
                        onClickRemove()
                    },
                    modifier = Modifier.size(16.dp).align(Alignment.TopEnd)
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "remove",
                        tint = DeceptionColor.OnSurface,
                    )
                }
            }
        }

        Spacer(Modifier.height(8.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            model.options.forEach { option ->
                val alpha = if (selectedOption == null || selectedOption == option) 1f else 0.4f

                Box(
                    Modifier
                        .alpha(alpha)
                        .fillMaxWidth()
                        .border(1.dp, DeceptionColor.OnSurface, RoundedCornerShape(4.dp))
                        .clickable { selectedOption = option.takeIf { selectedOption != option } }
                        .padding(8.dp)
                ) {
                    Text(
                        option,
                        color = DeceptionColor.OnSurface,
                        modifier = Modifier.align(Alignment.Center),
                        style = OptionTextStyle
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun ForensicTilePreview() {
    DeceptionTheme {
        ForensicTile(
            GenericForensicTileModel(
                "Location",
                listOf("Here", "There", "Garage", "Living Room", "Bedroom")
            ),
            color = DeceptionColor.LocationCard,
        )
    }
}
