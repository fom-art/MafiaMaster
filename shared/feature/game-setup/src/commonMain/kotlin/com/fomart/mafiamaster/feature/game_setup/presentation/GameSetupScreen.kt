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
import androidx.compose.ui.unit.dp
import com.fomart.mafiamaster.core.resources.components.CustomFilledButton
import com.fomart.mafiamaster.core.resources.components.DefaultTopBar
import com.fomart.mafiamaster.core.resources.components.HorizontalPlayerCountPicker
import com.fomart.mafiamaster.core.resources.components.RoleItemComponent
import com.fomart.mafiamaster.core.resources.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.model.GameSetup
import mafiamaster.shared.feature.game_setup.generated.resources.Res
import mafiamaster.shared.feature.game_setup.generated.resources.game_start
import mafiamaster.shared.feature.game_setup.generated.resources.setup_title
import org.jetbrains.compose.resources.stringResource

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
                title = stringResource(Res.string.setup_title),
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
            .padding(all = 16.dp),
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
            text = stringResource(Res.string.game_start),
        )
    }
}


fun Boolean.toInt() = if (this) 1 else 0