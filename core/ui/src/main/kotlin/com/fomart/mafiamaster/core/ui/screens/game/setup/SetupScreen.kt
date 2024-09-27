package com.fomart.mafiamaster.core.ui.screens.game.setup

import android.content.res.Configuration
import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.fomart.mafiamaster.core.model.setup.RoleItem
import com.fomart.mafiamaster.core.model.setup.RoleDistributionModel
import com.fomart.mafiamaster.core.ui.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.ui.components.CircleIcon
import com.fomart.mafiamaster.core.ui.components.CustomFilledButton
import com.fomart.mafiamaster.core.ui.components.DefaultTopBar
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue
import kotlin.math.ceil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultScaffoldScreen(
    modifier: Modifier = Modifier,
    roleDistributionModel: RoleDistributionModel,
    roleItems: List<RoleItem>,
    setPlayersTo: (Int) -> Unit,
    playerCounts: List<Int> = (6..12).toList(),
    goBack: () -> Unit,
    startGame: () -> Unit
) {
    // State for the scaffold (for handling things like the drawer state)

    // State for the FAB click action
    val showSnackbar = remember { mutableStateOf(false) }

    // Scaffold layout
    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultTopBar(
                title = stringResource(id = R.string.setup_title),
                goBack = goBack
            )
        },
    ) { innerPadding ->
        SetupBody(
            modifier = Modifier.padding(innerPadding),
            roleDistributionModel = roleDistributionModel,
            roleItems = roleItems,
            playerCounts = playerCounts,
            setPlayersTo = setPlayersTo,
            startGame = startGame
        )
    }
}

@Composable
fun SetupBody(
    modifier: Modifier = Modifier,
    roleDistributionModel: RoleDistributionModel,
    roleItems: List<RoleItem>,
    playerCounts: List<Int>,
    setPlayersTo: (Int) -> Unit,
    startGame: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(all = dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(roleItems) { roleItem ->
                RoleItemComponent(roleItem = roleItem)
            }
        }
        PlayersCountSetterLayout(
            playerCounts = playerCounts,
            setPlayersTo = setPlayersTo
        )
        CustomFilledButton(
            onClick = startGame,
            text = stringResource(id = R.string.game_start),
        )
    }
}

@Composable
fun RoleItemComponent(
    modifier: Modifier = Modifier,
    roleItem: RoleItem
) {
    val animationDuration = 350

    val containerColor =
        if (roleItem.isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 1f) else MaterialTheme.colorScheme.surfaceContainer
    val contentColor =
        if (roleItem.isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
    val iconColor =
        if (roleItem.isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 1f) else MaterialTheme.colorScheme.onSurface

    val animationSpec = tween<Color>(
        durationMillis = animationDuration,
        easing = FastOutLinearInEasing
    )

    val animatedContainerColor by animateColorAsState(
        targetValue = containerColor,
        animationSpec = animationSpec,
        label = ""
    )

    val animatedContentColor by animateColorAsState(
        targetValue = contentColor,
        animationSpec = animationSpec,
        label = ""
    )

    val animatedIconColor by animateColorAsState(
        targetValue = iconColor,
        animationSpec = animationSpec,
        label = ""
    )

    val cardColors = CardDefaults.cardColors().copy(
        containerColor = animatedContainerColor, contentColor = animatedContentColor
    )

    Card(
        modifier = modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_small)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { roleItem.onClick?.let { it() } },
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
            CircleIcon(
                painter = painterResource(id = roleItem.icon),
                iconColor = animatedIconColor
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = dimensionResource(R.dimen.padding_medium))
                    .weight(1f),
                text = stringResource(id = roleItem.title),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Medium
            )
            roleItem.count?.let {
                Text(
                    modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                    text = "${roleItem.count}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlayersCountSetterLayout(
    modifier: Modifier = Modifier,
    playerCounts: List<Int>,
    setPlayersTo: (Int) -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth(0.66f)
            .padding(vertical = dimensionResource(id = R.dimen.padding_small))
    ) {
        val contentPadding = (maxWidth - 50.dp) / 2
        val offSet = maxWidth / 3
        val itemSpacing = offSet - 50.dp

        // Set initial page based on the totalPlayers (find the index in playerCounts)
        val pagerState = rememberPagerState(pageCount = { playerCounts.size })

        LaunchedEffect(pagerState.currentPage) {
            setPlayersTo(playerCounts[pagerState.currentPage])
        }

        HorizontalPager(
            modifier = modifier.padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
            state = pagerState,
            flingBehavior = PagerDefaults.flingBehavior(
                state = pagerState,
                pagerSnapDistance = PagerSnapDistance.atMost(0)
            ),
            contentPadding = PaddingValues(horizontal = contentPadding),
            pageSpacing = itemSpacing,
        ) { page ->
            Box(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = ((pagerState.currentPage - page) + pagerState
                            .currentPageOffsetFraction).absoluteValue
                        // Set the item alpha based on the distance from the center
                        val percentFromCenter = 1.0f - (pageOffset / (5f / 2f))
                        val opacity = 0.25f + (percentFromCenter * 0.75f).coerceIn(0f, 1f)

                        alpha = opacity
                        clip = true
                    }
            ) {
                Text(
                    text = "${playerCounts[page]}",
                    modifier = Modifier
                        .wrapContentHeight(),
                    style = MaterialTheme.typography.displaySmall,
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun SetupScreenPreview() {
    var roleDistributionModel by remember {
        mutableStateOf(
            RoleDistributionModel(
                totalPlayers = 6,
                mafiaCount = 2,
                hasDon = false,
            )
        )
    }

    var hasMistress by remember { mutableStateOf(false) }
    var hasDoctor by remember { mutableStateOf(false) }
    var hasManiac by remember { mutableStateOf(false) }
    var hasCommissar by remember { mutableStateOf(false) }

    val setPlayersTo: (Int) -> Unit = { totalPlayers ->
        val hasDon = totalPlayers >= 10
        val mafiaCount: Int = totalPlayers / 3 - hasDon.toInt() - hasMistress.toInt()
        roleDistributionModel = roleDistributionModel.copy(
            totalPlayers = totalPlayers,
            hasDon = hasDon,
            mafiaCount = mafiaCount
        )

    }

    val createRoleItems: () -> List<RoleItem> = {
        listOf(
            RoleItem(
                title = R.string.role_mafia,
                icon = R.drawable.ic_mafia,
                count = roleDistributionModel.mafiaCount,
                isSelected = true,
            ),
            RoleItem(
                title = R.string.role_don,
                icon = R.drawable.ic_don,
                isSelected = roleDistributionModel.hasDon,
            ),
            RoleItem(
                title = R.string.role_mistress,
                icon = R.drawable.ic_mistress,
                isSelected = hasMistress,
                onClick = {
                    hasMistress = !hasMistress
                    setPlayersTo(roleDistributionModel.totalPlayers)
                },
            ),
            RoleItem(
                title = R.string.role_doctor,
                icon = R.drawable.ic_doctor,
                isSelected = hasDoctor,
                onClick = { hasDoctor = !hasDoctor },
            ),
            RoleItem(
                title = R.string.role_maniac,
                icon = R.drawable.ic_maniac,
                isSelected = hasManiac,
                onClick = { hasManiac = !hasManiac },

                ),
            RoleItem(
                title = R.string.role_commissar,
                icon = R.drawable.ic_sheriff,
                isSelected = hasCommissar,
                onClick = { hasCommissar = !hasCommissar },
            ),
        )
    }


    var roleItems by remember {
        mutableStateOf(createRoleItems())
    }

    LaunchedEffect(roleDistributionModel, hasMistress, hasDoctor, hasManiac, hasCommissar) {
        roleItems = createRoleItems()
    }

    MafiaMasterTheme {
        DefaultScaffoldScreen(
            roleItems = roleItems,
            roleDistributionModel = roleDistributionModel,
            setPlayersTo = setPlayersTo,
            goBack = {},
            startGame = {}
        )
    }
}

fun Boolean.toInt() = if (this) 1 else 0