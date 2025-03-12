import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fomart.mafiamaster.core.model.Player
import com.fomart.mafiamaster.core.model.Role
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.designsystem.components.CircleIcon
import com.fomart.mafiamaster.core.designsystem.theme.MafiaMasterTheme
import kotlin.random.Random

@Composable
fun RoleCard(
    modifier: Modifier = Modifier,
    player: Player,
    isFlipped: Boolean,
    onClicked: () -> Unit
) {
    // Animate the rotation
    val cardRotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f, label = ""
    )

    // Animate alpha for the content change
    val frontAlpha by animateFloatAsState(
        targetValue = if (isFlipped) 0f else 1f, label = ""
    )

    val backAlpha by animateFloatAsState(
        targetValue = if (isFlipped) 1f else 0f, label = ""
    )

    Card(
        modifier = modifier
            .fillMaxSize()
            .graphicsLayer {
                rotationY = cardRotation // Apply Y-axis rotation
                cameraDistance = 12f * density // Apply a camera distance to give 3D effect
            },
        shape = RoundedCornerShape(16.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClicked() }, contentAlignment = Alignment.Center) {
            // Front side content
            BackSideOfCard(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(frontAlpha) // Control visibility with alpha
            )
            // Back side content
            FrontSideOfCard(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(backAlpha) // Control visibility with alpha
                    .graphicsLayer {
                        rotationY = cardRotation // Apply Y-axis rotation
                        cameraDistance = 12f * density // Apply a camera distance to give 3D effect
                    },
                player = player
            )
        }
    }
}

@Composable
fun BackSideOfCard(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        RandomCardBackSideImage()
    }
}

@Composable
fun FrontSideOfCard(
    modifier: Modifier = Modifier,
    player: Player
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.role_player_number, player.number),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))

        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth()
        ) {
            val width = maxWidth * 0.37f

            CircleIcon(
                modifier = Modifier
                    .size(width)
                    .align(Alignment.Center),
                painter = painterResource(id = player.role.getImageFromRole()),
                backgroundColor = MaterialTheme.colorScheme.onSurfaceVariant,
                iconColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }

        Spacer(modifier = Modifier.fillMaxHeight(0.225f))

        Text(
            text = stringResource(id = player.role.getNameFromRole()),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun RandomCardBackSideImage(
    modifier: Modifier = Modifier
) {
    val images = listOf(
        painterResource(id = R.drawable.img_role_card_background_1),
        painterResource(id = R.drawable.img_role_card_background_2),
        painterResource(id = R.drawable.img_role_card_background_3),
    )

    val randomImage = images[Random.nextInt(images.size)]

    Image(
        modifier = modifier.alpha(0.2f),
        painter = randomImage,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun RoleCardPreview() {
    MafiaMasterTheme {
        val player = Player(number = 1, role = Role.MISTRESS)

        var isFlipped by remember { mutableStateOf(false) }

        Box(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            RoleCard(
                modifier = Modifier.align(Alignment.Center),
                player = player,
                isFlipped = isFlipped,
                onClicked = { isFlipped = !isFlipped }
            )
        }
    }
}
