package com.fomart.mafiamaster.core.designsystem.components

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.model.setup.RoleItem
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.designsystem.theme.MafiaMasterTheme

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

    val animatedIconColor = getAnimatedColor(
        isSelected = roleItem.isSelected,
        selectedColor = MaterialTheme.colorScheme.primary.copy(alpha = 1f),
        unselectedColor = MaterialTheme.colorScheme.onSurface,
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
        animatedIconColor = animatedIconColor
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
    animatedIconColor: Color
) {
    Card(
        modifier = modifier
            .padding(vertical = dimensionResource(id = R.dimen.padding_small))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { roleItem.onClick?.invoke() },
        colors = cardColors
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium),
                    vertical = dimensionResource(id = R.dimen.padding_medium)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Display the circle icon
            CircleIcon(
                painter = painterResource(id = roleItem.icon),
                iconColor = animatedIconColor
            )

            // Display the role title
            RoleTitle(
                title = stringResource(id = roleItem.title)
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
            .padding(horizontal = dimensionResource(R.dimen.padding_medium))
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
        modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
        text = "$count",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Medium
    )
}

@Preview
@Composable
fun RoleItemComponentPreview() {
    var hasMistress by remember { mutableStateOf(false) }

    MafiaMasterTheme {
        RoleItemComponent(
            roleItem = RoleItem(
                title = R.string.role_mistress,
                icon = R.drawable.ic_mistress,
                isSelected = hasMistress,
                onClick = { hasMistress = !hasMistress },
            )
        )
    }
}
