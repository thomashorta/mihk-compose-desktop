package component

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import theme.CustomColor
import theme.PlayerCardTextStyle

@Composable
fun PlayerCard(
    text: String,
    modifier: Modifier = Modifier,
    image: String = "", // TODO figure out what to use for image
    background: Color = CustomColor.CardBgDefault,
) {
    Column(
        modifier
            .clip(RoundedCornerShape(8.dp))
            .aspectRatio(3f / 4f, matchHeightConstraintsFirst = true)
            .background(background)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .weight(1f)
                .fillMaxWidth()
                .background(Color.White)
        ) {
            // TODO image here
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text.uppercase(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = PlayerCardTextStyle
            )
        }
    }
}
