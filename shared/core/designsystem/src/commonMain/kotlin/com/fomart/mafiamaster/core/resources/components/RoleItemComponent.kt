package com.fomart.mafiamaster.core.resources.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.fomart.mafiamaster.core.resources.model.RoleItem
import org.jetbrains.compose.resources.vectorResource

@Composable
fun RoleItemComponent(
    modifier: Modifier = Modifier,
    roleItem: RoleItem
) {
    val animationDuration = 350
    val animationSpec = tween<Color>(
        durationMillis = animationDuration,
        easing = FastOutLinearInEasing
    )

    // Get animated colors based on whether the role item is selected
    val animatedContainerColor = getAnimatedColor(
        isSelected = roleItem.isSelected,
        selectedColor = MaterialTheme.colorScheme.primary.copy(alpha = 1f),
        unselectedColor = MaterialTheme.colorScheme.surfaceContainer,
        animationSpec = animationSpec
    )

    val animatedContentColor = getAnimatedColor(
        isSelected = roleItem.isSelected,
        selectedColor = MaterialTheme.colorScheme.onPrimary,
        unselectedColor = MaterialTheme.colorScheme.onSurface,
        animationSpec = animationSpec
    )

    val iconColor = getAnimatedColor(
        isSelected = roleItem.isSelected,
        selectedColor = MaterialTheme.colorScheme.primary.copy(alpha = 1f),
        unselectedColor = MaterialTheme.colorScheme.surfaceContainer,
        animationSpec = animationSpec
    )

    // Define the card colors
    val cardColors = getCardColors(
        containerColor = animatedContainerColor,
        contentColor = animatedContentColor
    )

    // Render the Card component
    RoleCard(
        modifier = modifier,
        roleItem = roleItem,
        cardColors = cardColors,
        iconBackgroundColor = Color.White,
        iconColor = iconColor
    )
}

// Function to animate color change
@Composable
private fun getAnimatedColor(
    isSelected: Boolean,
    selectedColor: Color,
    unselectedColor: Color,
    animationSpec: AnimationSpec<Color>
): Color {
    val targetColor = if (isSelected) selectedColor else unselectedColor
    val animatedColor by animateColorAsState(
        targetValue = targetColor,
        animationSpec = animationSpec,
        label = ""
    )
    return animatedColor
}

// Function to define card colors
@Composable
private fun getCardColors(containerColor: Color, contentColor: Color): CardColors {
    return CardDefaults.cardColors().copy(
        containerColor = containerColor,
        contentColor = contentColor
    )
}

// Function to render the card UI
@Composable
private fun RoleCard(
    modifier: Modifier,
    roleItem: RoleItem,
    cardColors: CardColors,
    iconBackgroundColor: Color,
    iconColor: Color
) {
    Card(
        modifier = modifier
            .padding(vertical = 8.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { roleItem.onClick?.invoke() },
        colors = cardColors
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display the circle icon
            CircleIcon(
                imageVector = vectorResource(roleItem.icon),
                backgroundColor = iconBackgroundColor,
                iconColor = iconColor
            )

            // Display the role title
            RoleTitle(
                title = roleItem.title.asString()
            )

            // Optionally display the role count
            roleItem.count?.let {
                RoleCountText(count = it)
            }
        }
    }
}

// Function to display the role title
@Composable
private fun RowScope.RoleTitle(title: String) {
    Text(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .weight(1f),
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Medium
    )
}

// Function to display the role count
@Composable
private fun RoleCountText(count: Int) {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = "$count",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Medium
    )
}

