package com.fomart.mafiamaster.core.ui.screens.game.setup

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.ui.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.ui.components.CustomFilledButton
import com.fomart.mafiamaster.core.ui.components.DefaultTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultScaffoldScreen(
    modifier: Modifier = Modifier,
    goBack: () -> Unit,
) {
    // State for the scaffold (for handling things like the drawer state)

    // State for the FAB click action
    val showSnackbar = remember { mutableStateOf(false) }

    // Scaffold layout
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = stringResource(id = R.string.setup_title),
                goBack = goBack
            )
        },
    ) { innerPadding ->
        SetupBody(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun SetupBody(
    modifier: Modifier = Modifier,
) {

}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun HomeScreenPreview() {
    MafiaMasterTheme {
        DefaultScaffoldScreen(
            goBack = {}
        )
    }
}