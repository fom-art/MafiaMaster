package com.fomart.mafiamaster.feature.game_setup.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.designsystem.components.CustomFilledButton
import com.fomart.mafiamaster.core.designsystem.components.DefaultTopBar
import com.fomart.mafiamaster.core.designsystem.components.HorizontalPlayerCountPicker
import com.fomart.mafiamaster.core.designsystem.components.RoleItemComponent
import com.fomart.mafiamaster.core.designsystem.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.model.GameSetup

@Composable
fun GameSetupScreen(
    modifier: Modifier = Modifier,
    state: GameSetup,
    onAction: (GameSetupIntent) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultTopBar(
                title = stringResource(id = R.string.setup_title),
                goBack = { onAction(GameSetupIntent.GoBack) }
            )
        },
    ) { innerPadding ->
        GameSetupBody(
            modifier = Modifier.padding(innerPadding),
            state = state,
            onAction = onAction
        )
    }
}

@Composable
fun GameSetupBody(
    modifier: Modifier = Modifier,
    state: GameSetup,
    onAction: (GameSetupIntent) -> Unit
) {
    Column(
        modifier = modifier
            .padding(all = dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(
                state.toRoleItems(
                    onMistressClicked = { onAction(GameSetupIntent.ToggleMistress) },
                    onDoctorClicked = { onAction(GameSetupIntent.ToggleDoctor) },
                    onManiacClicked = { onAction(GameSetupIntent.ToggleManiac) },
                    onCommissarClicked = { onAction(GameSetupIntent.ToggleCommissar) },
                )
            ) { roleItem ->
                RoleItemComponent(roleItem = roleItem)
            }
        }
        HorizontalPlayerCountPicker(
            playerCounts = (6..12).toList(),
            setPlayersTo = { onAction(GameSetupIntent.ChangePlayersAmount(it)) }
        )
        CustomFilledButton(
            onClick = { onAction(GameSetupIntent.StartGame) },
            text = stringResource(id = R.string.game_start),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SetupScreenPreview() {
    var state by remember { mutableStateOf(GameSetup()) }

    MafiaMasterTheme {
        GameSetupScreen(
            state = state,
            onAction = { intent ->
                when (intent) {
                    is GameSetupIntent.ChangePlayersAmount -> {
                        val hasDon = intent.playersAmount >= 9
                        val mafiaCount =
                            intent.playersAmount / 3 - hasDon.toInt() - state.hasMistress.toInt()
                        state = state.copy(
                            totalPlayers = intent.playersAmount,
                            hasDon = hasDon,
                            mafiaCount = mafiaCount
                        )
                    }

                    GameSetupIntent.ToggleMistress -> {
                        state = state.copy(hasMistress = !state.hasMistress)
                        // Recalculate mafia count
                        val hasDon = state.totalPlayers >= 9
                        val mafiaCount =
                            state.totalPlayers / 3 - hasDon.toInt() - state.hasMistress.toInt()
                        state = state.copy(mafiaCount = mafiaCount)
                    }

                    GameSetupIntent.ToggleDoctor -> {
                        state = state.copy(hasDoctor = !state.hasDoctor)
                    }

                    GameSetupIntent.ToggleManiac -> {
                        state = state.copy(hasManiac = !state.hasManiac)
                    }

                    GameSetupIntent.ToggleCommissar -> {
                        state = state.copy(hasCommissar = !state.hasCommissar)
                    }

                    GameSetupIntent.GoBack -> {}

                    GameSetupIntent.StartGame -> {}
                }
            }
        )
    }
}


fun Boolean.toInt() = if (this) 1 else 0