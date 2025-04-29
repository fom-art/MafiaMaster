package com.fomart.mafiamaster.feature.roles_distribution.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fomart.mafiamaster.core.model.Player
import com.fomart.mafiamaster.core.resources.components.RoleCard

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
            modifier = Modifier,
            state = pagerState,
            userScrollEnabled = scrollEnabled,
        ) { playerIndex ->
            // Page Item
            var isFlipped by remember { mutableStateOf(false) }
            Spacer(Modifier.fillMaxHeight(0.15f))
            RoleCard(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.70f),
                player = players[playerIndex],
                isFlipped = isFlipped,
                onClicked = { isFlipped = !isFlipped })
            Spacer(Modifier.fillMaxHeight(0.15f))
        }
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