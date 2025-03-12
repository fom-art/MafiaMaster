package com.fomart.mafiamaster.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberApplicationState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): MafiaMasterState {
    return remember(coroutineScope, navController) {
        MafiaMasterState(
            navController = navController,
            coroutineScope = coroutineScope
        )
    }
}

@Stable
class MafiaMasterState(
    val navController: NavHostController,
    private val coroutineScope: CoroutineScope,
) {

}