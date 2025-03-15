package com.fomart.mafiamaster.feature.homepage.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fomart.mafiamaster.feature.homepage.HomepageRoute
import kotlinx.serialization.Serializable

@Serializable
data object HomepageScreen

fun NavController.navigateToHomepage(navOptions: NavOptions? = null) =
    navigate(HomepageScreen, navOptions)

fun NavGraphBuilder.homepageScreen(
    navigateToGameSetup: () -> Unit
) {
    composable<HomepageScreen> {
        HomepageRoute(
            goToGameSetup = navigateToGameSetup
        )
    }
}