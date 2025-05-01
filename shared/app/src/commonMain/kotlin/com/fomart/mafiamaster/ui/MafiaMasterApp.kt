package com.fomart.mafiamaster.ui

import androidx.compose.foundation.background
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import com.fomart.mafiamaster.navigation.MafiaMasterNavHost

@Composable
fun MafiaMasterApp(
    modifier: Modifier = Modifier,
//    windowAdaptiveInfo: WindowAdaptiveInfo = currentWindowAdaptiveInfo(),
) {
    val appState = rememberApplicationState()
    val snackbarHostState = remember { SnackbarHostState() }

    MafiaMasterNavHost(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        appState = appState,
        onShowSnackbar = { message, action ->
            snackbarHostState.showSnackbar(
                message = message,
                actionLabel = action,
                duration = SnackbarDuration.Short,
            ) == SnackbarResult.ActionPerformed
        }
    )
}