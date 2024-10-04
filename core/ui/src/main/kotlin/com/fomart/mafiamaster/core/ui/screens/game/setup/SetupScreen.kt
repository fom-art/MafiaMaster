package com.fomart.mafiamaster.core.ui.screens.game.setup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.model.setup.RoleItem
import com.fomart.mafiamaster.core.model.setup.RoleDistributionModel
import com.fomart.mafiamaster.core.ui.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.ui.components.CustomFilledButton
import com.fomart.mafiamaster.core.ui.components.DefaultTopBar
import com.fomart.mafiamaster.core.ui.components.HorizontalPlayerCountPicker
import com.fomart.mafiamaster.core.ui.components.RoleItemComponent

@Composable
fun DefaultScaffoldScreen(
    modifier: Modifier = Modifier,
    roleDistributionModel: RoleDistributionModel,
    playerCounts: List<Int> = (6..12).toList(),
    onMistressClicked: () -> Unit,
    onDoctorClicked: () -> Unit,
    onManiacClicked: () -> Unit,
    onCommissarClicked: () -> Unit,
    setPlayersTo: (Int) -> Unit,
    goBack: () -> Unit,
    startGame: () -> Unit
) {
    // State for the scaffold (for handling things like the drawer state)

    // State for the FAB click action
    val showSnackbar = remember { mutableStateOf(false) }

    // Scaffold layout
    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultTopBar(
                title = stringResource(id = R.string.setup_title),
                goBack = goBack
            )
        },
    ) { innerPadding ->
        SetupBody(
            modifier = Modifier.padding(innerPadding),
            roleDistributionModel = roleDistributionModel,
            playerCounts = playerCounts,
            setPlayersTo = setPlayersTo,
            onMistressClicked = onMistressClicked,
            onDoctorClicked = onDoctorClicked,
            onManiacClicked = onManiacClicked,
            onCommissarClicked = onCommissarClicked,
            startGame = startGame
        )
    }
}

@Composable
fun SetupBody(
    modifier: Modifier = Modifier,
    roleDistributionModel: RoleDistributionModel,
    playerCounts: List<Int>,
    setPlayersTo: (Int) -> Unit,
    onMistressClicked: () -> Unit,
    onDoctorClicked: () -> Unit,
    onManiacClicked: () -> Unit,
    onCommissarClicked: () -> Unit,
    startGame: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(all = dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(
                roleDistributionModel.toRoleItems(
                    onMistressClicked = onMistressClicked,
                    onDoctorClicked = onDoctorClicked,
                    onManiacClicked = onManiacClicked,
                    onCommissarClicked = onCommissarClicked,
                )
            ) { roleItem ->
                RoleItemComponent(roleItem = roleItem)
            }
        }
        HorizontalPlayerCountPicker(
            playerCounts = playerCounts,
            setPlayersTo = setPlayersTo
        )
        CustomFilledButton(
            onClick = startGame,
            text = stringResource(id = R.string.game_start),
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun SetupScreenPreview() {
    var roleDistributionModel by remember { mutableStateOf(RoleDistributionModel()) }

    val setPlayersTo: (Int) -> Unit = { totalPlayers ->
        val hasDon = totalPlayers >= 9
        val mafiaCount: Int =
            totalPlayers / 3 - hasDon.toInt() - roleDistributionModel.hasMistress.toInt()
        roleDistributionModel = roleDistributionModel.copy(
            totalPlayers = totalPlayers,
            hasDon = hasDon,
            mafiaCount = mafiaCount
        )
    }

    MafiaMasterTheme {
        DefaultScaffoldScreen(
            roleDistributionModel = roleDistributionModel,
            setPlayersTo = setPlayersTo,
            goBack = {},
            onMistressClicked = {
                roleDistributionModel =
                    roleDistributionModel.copy(hasMistress = !roleDistributionModel.hasMistress)
                setPlayersTo(roleDistributionModel.totalPlayers)
            },
            onDoctorClicked = {
                roleDistributionModel =
                    roleDistributionModel.copy(hasDoctor = !roleDistributionModel.hasDoctor)
            },
            onManiacClicked = {
                roleDistributionModel =
                    roleDistributionModel.copy(hasManiac = !roleDistributionModel.hasManiac)
            },
            onCommissarClicked = {
                roleDistributionModel =
                    roleDistributionModel.copy(hasCommissar = !roleDistributionModel.hasCommissar)
            },
            startGame = {}
        )
    }
}


fun Boolean.toInt() = if (this) 1 else 0