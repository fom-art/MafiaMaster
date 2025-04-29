package com.fomart.mafiamaster.feature.game_setup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fomart.mafiamaster.feature.game_setup.presentation.GameSetupRoute
import kotlinx.serialization.Serializable

@Serializable
data object GameSetupScreen

fun NavController.navigateToGameSetup(navOptions: NavOptions? = null) =
    navigate(GameSetupScreen, navOptions)

fun NavGraphBuilder.gameSetupScreen(
    navigateToRolesDistribution: () -> Unit,
    goBack: () -> Unit,
) {
    composable<GameSetupScreen> {
        GameSetupRoute(
            navigateToRolesDistribution = navigateToRolesDistribution,
            goBack = goBack
        )
    }
}