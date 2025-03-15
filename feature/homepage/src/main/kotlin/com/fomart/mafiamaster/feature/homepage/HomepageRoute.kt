package com.fomart.mafiamaster.feature.homepage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

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