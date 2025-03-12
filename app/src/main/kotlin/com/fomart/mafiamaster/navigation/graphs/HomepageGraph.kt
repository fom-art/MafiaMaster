package com.fomart.mafiamaster.navigation.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.wf.bm.feature.homepage.navigation.HomepageScreen
import com.wf.bm.feature.homepage.navigation.homepageScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomepageGraph

fun NavGraphBuilder.homepageGraph(
    navController: NavController,
) {
//    navigation<HomepageGraph>(
//        startDestination = HomepageScreen,
//    ) {
//        homepageScreen()
//    }
}