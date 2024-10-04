package com.fomart.mafiamaster.core.ui.screens.game.distribution

import RoleCard
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fomart.mafiamaster.core.model.Player
import com.fomart.mafiamaster.core.model.Role
import com.fomart.mafiamaster.core.ui.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.ui.components.CustomFilledButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DistributionScreen(
    modifier: Modifier = Modifier,
    canSwipe: Boolean,
    players: List<Player>,
) {
    Column(
        modifier = modifier
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        // Mutable list of pages
        val pagerState = rememberPagerState(pageCount = { players.size })
        val scrollEnabled by remember {
            derivedStateOf {
                pagerState.currentPageOffsetFraction >= 0
            }
        }

        VerticalPager(
            modifier = Modifier
                .fillMaxSize(),
            state = pagerState,
            userScrollEnabled = scrollEnabled,
        ) { playerIndex ->
            // Page Item
            var isFlipped by remember { mutableStateOf(false) }

            RoleCard(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.75f),
                player = players[playerIndex],
                isFlipped = isFlipped,
                onClicked = { isFlipped = !isFlipped })
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun DistributionScreenPreview() {
    val players = listOf(
        Player(
            number = 1,
            role = Role.MISTRESS
        ),
        Player(
            number = 2,
            role = Role.MANIAC
        ),
        Player(
            number = 3,
            role = Role.CIVILIAN
        ),
        Player(
            number = 4,
            role = Role.CIVILIAN
        ),
        Player(
            number = 5,
            role = Role.DOCTOR
        ),
        Player(
            number = 6,
            role = Role.MANIAC
        )
    )
    var canSwipe by remember { mutableStateOf(true) }
    MafiaMasterTheme {
        DistributionScreen(
            canSwipe = canSwipe,
            players = players
        )
    }
}

//@OptIn(ExperimentalFoundationApi::class)
//fun Modifier.disableBackwardScroll(pagerState: PagerState): Modifier {
//    return this.pointerInput(Unit) {
//        detectVerticalDragGestures { change, dragAmount ->
//            // Only allow scrolling forward
//            if (dragAmount > 0 && pagerState.currentPage > 0) {
//                change.consume()
//            }
//        }
//    }
//}


//@OptIn(ExperimentalFoundationApi::class)
//fun PagerState.removeScrollBack() {
//    this.canScrollBackward = false
//}