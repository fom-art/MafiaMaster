package com.fomart.mafiamaster.feature.game_setup.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fomart.mafiamaster.feature.game_setup.GameRoute
import kotlinx.serialization.Serializable

@Serializable
data object GameScreen

fun NavController.navigateToGame(navOptions: NavOptions? = null) =
    navigate(GameScreen, navOptions)

fun NavGraphBuilder.gameScreen() {
    composable<GameScreen> {
        GameRoute()
    }
}