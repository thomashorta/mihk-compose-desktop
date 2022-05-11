package theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun DeceptionTheme(
    content: @Composable () -> Unit,
) = MaterialTheme(
    colors = lightColors(
        primary = DeceptionColor.Primary
    ),
    content = content,
)