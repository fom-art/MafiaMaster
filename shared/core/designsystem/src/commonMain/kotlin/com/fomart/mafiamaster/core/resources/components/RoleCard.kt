package com.fomart.mafiamaster.core.resources.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fomart.mafiamaster.core.model.Player
import mafiamaster.shared.core.designsystem.generated.resources.Res
import mafiamaster.shared.core.designsystem.generated.resources.img_role_card_background_1
import mafiamaster.shared.core.designsystem.generated.resources.img_role_card_background_2
import mafiamaster.shared.core.designsystem.generated.resources.img_role_card_background_3
import mafiamaster.shared.core.designsystem.generated.resources.player
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource
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
        shape = RoundedCornerShape(32.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClicked() }, contentAlignment = Alignment.Center
        ) {
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
                    .alpha(backAlpha)// Control visibility with alpha
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
    RandomCardBackSideImage(modifier = modifier)
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
            text = "${stringResource(Res.string.player)} ${player.number}",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.fillMaxHeight(0.05f))

        CircleIcon(
            modifier = Modifier
                .fillMaxWidth(0.37f)
                .aspectRatio(1f),
            imageVector = vectorResource(player.role.getImageFromRole()),
            backgroundColor = MaterialTheme.colorScheme.onSurfaceVariant,
            iconColor = MaterialTheme.colorScheme.surfaceVariant
        )

        Spacer(modifier = Modifier.fillMaxHeight(0.225f))

        Text(
            text = player.role.getNameFromRole().asString(),
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
        painterResource(Res.drawable.img_role_card_background_1),
        painterResource(Res.drawable.img_role_card_background_2),
        painterResource(Res.drawable.img_role_card_background_3),
    )

    var randomImage: Painter = images[0]
    LaunchedEffect(Unit) {
        randomImage = images[Random.nextInt(images.size)]
    }

    Image(
        modifier = modifier.alpha(0.2f),
        painter = randomImage,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center
    )
}