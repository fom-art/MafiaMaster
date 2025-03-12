package com.fomart.mafiamaster.ui

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult.ActionPerformed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.adaptive.WindowAdaptiveInfo
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.remember
import com.fomart.mafiamaster.navigation.MafiaMasterNavHost

@Composable
fun MafiaMasterApp(
    modifier: Modifier = Modifier,
    appState: MafiaMasterState,
    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    val snackbarHostState = remember { SnackbarHostState() }

    MafiaMasterNavHost(
        modifier = modifier,
        appState = appState,
        onShowSnackbar = { message, action ->
            snackbarHostState.showSnackbar(
                message = message,
                actionLabel = action,
                duration = SnackbarDuration.Short,
            ) == ActionPerformed
        }
    )
}