package com.fomart.mafiamaster.feature.game_setup.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameSetupRoute(
    modifier: Modifier = Modifier,
    viewModel: GameSetupViewModel = koinViewModel(),
    navigateToRolesDistribution: () -> Unit,
    goBack: () -> Unit,
) {
    GameSetupScreen(
        modifier = modifier,
        state = viewModel.state,
        onAction = { action ->
            when(action) {
                is GameSetupIntent.StartGame -> navigateToRolesDistribution()
                is GameSetupIntent.GoBack -> goBack()
                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}