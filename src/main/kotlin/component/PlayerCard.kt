package component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import theme.DeceptionColor
import theme.PlayerCardTextStyle

@Composable
fun PlayerCard(
    text: String,
    modifier: Modifier = Modifier,
    image: String? = null, // TODO figure out what to use for image
    background: Color = DeceptionColor.DefaultCard,
) {
    var isSelected by remember { mutableStateOf(false) }

    var cardModifier = modifier.background(background, RoundedCornerShape(8.dp))
    image?.let { cardModifier = cardModifier.aspectRatio(3f / 4f) }
    if (isSelected) {
        cardModifier = cardModifier.border(2.dp, DeceptionColor.CardSelectedBorder, RoundedCornerShape(8.dp))
    }
    cardModifier = cardModifier.padding(8.dp).clickable { isSelected = !isSelected }

    Column(
        cardModifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        image?.let {
            // only show the image section if there's one
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                // TODO image here
            }
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .fillMaxWidth()
                .background(Color.White)
                .padding(4.dp),
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
