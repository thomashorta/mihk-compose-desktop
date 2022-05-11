package component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import theme.CustomColor

@Composable
fun PlayerBoard(
    name: String,
    means: List<String>,
    weapons: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardRow(
            cards = means,
            cardBackground = CustomColor.CardBgMeans,
            modifier = Modifier.weight(1f),
        )
        Spacer(Modifier.height(4.dp))
        CardRow(
            cards = weapons,
            cardBackground = CustomColor.CardBgWeapons,
            modifier = Modifier.weight(1f),
        )
        Spacer(Modifier.height(8.dp))
        Text(name)
    }
}

@Composable
private fun CardRow(
    cards: List<String>,
    cardBackground: Color,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        cards.forEach {
            PlayerCard(
                it,
                background = cardBackground
            )
        }
    }
}
