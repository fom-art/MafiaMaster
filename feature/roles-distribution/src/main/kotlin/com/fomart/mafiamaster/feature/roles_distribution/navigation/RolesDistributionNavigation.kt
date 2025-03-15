package com.fomart.mafiamaster.feature.roles_distribution.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fomart.mafiamaster.feature.roles_distribution.RolesDistributionRoute
import kotlinx.serialization.Serializable

@Serializable
data object RolesDistributionScreen

fun NavController.navigateToRolesDistribution(navOptions: NavOptions? = null) =
    navigate(RolesDistributionScreen, navOptions)

fun NavGraphBuilder.rolesDistributionScreen(
    navigateToGame: () -> Unit
) {
    composable<RolesDistributionScreen> {
        RolesDistributionRoute(
            navigateToGame = navigateToGame
        )
    }
}