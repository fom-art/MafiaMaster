package com.fomart.mafiamaster.core.designsystem.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.designsystem.theme.MafiaMasterTheme
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPlayerCountPicker(
    modifier: Modifier = Modifier,
    playerCounts: List<Int>,
    setPlayersTo: (Int) -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth(0.66f)
            .padding(vertical = dimensionResource(id = R.dimen.padding_small))
    ) {
        val contentPadding = calculateContentPadding(maxWidth)
        val itemSpacing = calculateItemSpacing(maxWidth)

        val pagerState = rememberPagerState(pageCount = { playerCounts.size })

        // Update the selected player count when the page changes
        LaunchedEffect(pagerState.currentPage) {
            setPlayersTo(playerCounts[pagerState.currentPage])
        }

        HorizontalPlayerPager(
            modifier = modifier,
            pagerState = pagerState,
            contentPadding = contentPadding,
            itemSpacing = itemSpacing,
            playerCounts = playerCounts
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HorizontalPlayerPager(
    modifier: Modifier,
    pagerState: PagerState,
    contentPadding: Dp,
    itemSpacing: Dp,
    playerCounts: List<Int>
) {
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
        PlayerCountItem(page = page, pagerState = pagerState, playerCount = playerCounts[page])
    }
}

// Calculate content padding to center the pager items
@Composable
private fun calculateContentPadding(maxWidth: Dp): Dp {
    return (maxWidth - 50.dp) / 2
}

// Calculate item spacing based on the available width
@Composable
private fun calculateItemSpacing(maxWidth: Dp): Dp {
    val offSet = maxWidth / 4
    return offSet - 50.dp
}

// Render each item in the horizontal pager
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PlayerCountItem(
    page: Int,
    pagerState: PagerState,
    playerCount: Int
) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .graphicsLayer {
                val pageOffset =
                    ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
                alpha = calculateOpacity(pageOffset)
                clip = true
            }
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .wrapContentHeight(),
            text = "$playerCount",
            style = MaterialTheme.typography.displaySmall,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center
        )
    }
}

// Calculate opacity based on the offset from the center
private fun calculateOpacity(pageOffset: Float): Float {
    val percentFromCenter = 1.0f - (pageOffset / (5f / 2f))
    return (0.25f + (percentFromCenter * 0.75f)).coerceIn(0f, 1f)
}

@Preview(showBackground = true)
@Composable
fun HorizontalPlayerCountPickerPreview() {
    MafiaMasterTheme {
        HorizontalPlayerCountPicker(
            playerCounts = (6..12).toList(),
            setPlayersTo = {}
        )
    }
}
