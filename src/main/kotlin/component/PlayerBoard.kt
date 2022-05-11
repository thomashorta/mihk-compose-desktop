package component

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import domain.PlayerCardModel
import domain.PlayerModel
import theme.DeceptionColor

private val PlayerNameTextStyle = TextStyle(
    fontWeight = FontWeight.W300,
    fontSize = 14.sp,
    letterSpacing = 2.sp,
)

@Composable
fun PlayerBoard(
    playerModel: PlayerModel,
    onBadgeClicked: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .background(DeceptionColor.Surface, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                CardRow(
                    cards = playerModel.clues,
                    cardBackground = DeceptionColor.ClueCard,
                    modifier = Modifier.weight(1f, false),
                )

                Spacer(Modifier.height(4.dp))

                CardRow(
                    cards = playerModel.means,
                    cardBackground = DeceptionColor.MeansCard,
                    modifier = Modifier.weight(1f, false),
                )
            }

            Spacer(Modifier.width(8.dp))

            val badgeShape = RoundedCornerShape(4.dp)
            var badgeModifier = Modifier
                .height(48.dp)
                .aspectRatio(6f / 11, true)
                .clip(badgeShape)
                .clickable { onBadgeClicked() }

            if (!playerModel.hasBadge) {
                badgeModifier = badgeModifier.border(1.dp, Color.Red, badgeShape).alpha(0.2f)
            }

            Image(
                painterResource("badge.png"),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = badgeModifier,
            )
        }

        Spacer(Modifier.height(8.dp))

        Text(
            playerModel.name,
            color = DeceptionColor.OnSurface,
            textAlign = TextAlign.Center,
            style = PlayerNameTextStyle,
        )
    }
}

@Composable
private fun CardRow(
    cards: List<PlayerCardModel>,
    cardBackground: Color,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        cards.forEach {
            PlayerCard(
                it.text,
                background = cardBackground,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
@Preview
fun PreviewPlayerBoard() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .width(640.dp)
                .height(480.dp)
                .padding(8.dp)
        ) {
            PlayerBoard(
                PlayerModel(
                    "Player",
                    clues = listOf("Hat", "Cup", "Fan", "Baseball bat").map { PlayerCardModel(it) },
                    means = listOf("Surgery", "Punch", "Knife", "Car").map { PlayerCardModel(it) }
                ),
            )
        }
    }
}
