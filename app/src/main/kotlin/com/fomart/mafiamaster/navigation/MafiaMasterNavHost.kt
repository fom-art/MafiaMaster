package com.fomart.mafiamaster.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.fomart.mafiamaster.feature.game_setup.navigation.gameScreen
import com.fomart.mafiamaster.feature.game_setup.navigation.gameSetupScreen
import com.fomart.mafiamaster.feature.game_setup.navigation.navigateToGame
import com.fomart.mafiamaster.feature.game_setup.navigation.navigateToGameSetup
import com.fomart.mafiamaster.feature.homepage.navigation.HomepageScreen
import com.fomart.mafiamaster.feature.homepage.navigation.homepageScreen
import com.fomart.mafiamaster.feature.roles_distribution.navigation.navigateToRolesDistribution
import com.fomart.mafiamaster.feature.roles_distribution.navigation.rolesDistributionScreen
import com.fomart.mafiamaster.ui.MafiaMasterState

@Composable
fun MafiaMasterNavHost(
    modifier: Modifier = Modifier,
    appState: MafiaMasterState,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = HomepageScreen,
        modifier = modifier,
    ) {
        homepageScreen(navigateToGameSetup = navController::navigateToGameSetup)
        gameSetupScreen(
            navigateToRolesDistribution =
                navController::navigateToRolesDistribution,
            goBack = navController::navigateUp
        )
        rolesDistributionScreen(navigateToGame = navController::navigateToGame)
        gameScreen()
    }
}