import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fomart.mafiamaster.core.ui.theme.MafiaMasterTheme

@Composable
fun FlipCard() {
    // State to track whether the card is flipped or not
    var isFlipped by remember { mutableStateOf(false) }

    // Animate the rotation
    val _rotationY by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f
    )

    // Animate alpha for the content change
    val frontAlpha by animateFloatAsState(
        targetValue = if (isFlipped) 0f else 1f
    )
    val backAlpha by animateFloatAsState(
        targetValue = if (isFlipped) 1f else 0f
    )

    // Card composable with Y-axis flip animation
    Card(
        modifier = Modifier
            .size(200.dp) // Card size
            .clickable { isFlipped = !isFlipped } // Flip the card on click
            .graphicsLayer {
                rotationY = _rotationY // Apply Y-axis rotation
                cameraDistance = 12f * density // Apply a camera distance to give 3D effect
            },
        shape = RoundedCornerShape(16.dp),
//        elevation = 8.dp,
        colors = androidx.compose.material3.CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            // Front side content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(frontAlpha) // Control visibility with alpha
            ) {
                Text(
                    text = "Front",
                    fontSize = 24.sp,
                    color = Color.Blue,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            // Back side content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(backAlpha)
                    .graphicsLayer {
                        rotationY = _rotationY // Apply Y-axis rotation
                        cameraDistance = 12f * density // Apply a camera distance to give 3D effect
                    }// Control visibility with alpha
            ) {
                Text(
                    text = "Back",
                    fontSize = 24.sp,
                    color = Color.Green,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlipCardPreview() {
    MafiaMasterTheme {
        FlipCard()
    }
}
