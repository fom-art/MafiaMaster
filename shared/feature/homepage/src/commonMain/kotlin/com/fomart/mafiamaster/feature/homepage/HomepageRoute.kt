package com.fomart.mafiamaster.feature.homepage

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomepageRoute(
    modifier: Modifier = Modifier,
    goToGameSetup: () -> Unit,
) {
    HomepageScreen(
        modifier = modifier,
        goToGameSetup = goToGameSetup
    )
}