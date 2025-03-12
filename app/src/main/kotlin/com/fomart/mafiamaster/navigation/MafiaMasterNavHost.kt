package com.fomart.mafiamaster.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.fomart.mafiamaster.navigation.graphs.HomepageGraph
import com.fomart.mafiamaster.navigation.graphs.homepageGraph
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
        startDestination = HomepageGraph,
        modifier = modifier,
    ){
        homepageGraph(navController = navController)
    }
}