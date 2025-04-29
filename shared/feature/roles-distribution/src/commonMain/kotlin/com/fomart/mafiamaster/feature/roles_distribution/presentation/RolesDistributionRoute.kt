package com.fomart.mafiamaster.feature.roles_distribution.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RolesDistributionRoute(
    modifier: Modifier = Modifier,
    viewModel: RolesDistributionViewModel = koinViewModel(),
    navigateToGame: () -> Unit
) {
    DistributionScreen(
        modifier = modifier,
        canSwipe = viewModel.canSwipe,
        players = viewModel.players
    )
}