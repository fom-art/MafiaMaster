package com.fomart.mafiamaster.core.ui.screens.game.distribution

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.model.Player
import com.fomart.mafiamaster.core.model.Role
import com.fomart.mafiamaster.core.ui.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.ui.components.CustomFilledButton

@Composable
fun DistributionScreen(
    modifier: Modifier = Modifier,
    canSwipe: Boolean,
    players: List<Player>,
    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun DistributionScreenPreview() {
    val players = listOf(
        Player(
            number = 1,
            role = Role.MISTRESS
        ),
        Player(
            number = 2,
            role = Role.MANIAC
        ),
        Player(
            number = 3,
            role = Role.CIVILIAN
        ),
        Player(
            number = 4,
            role = Role.CIVILIAN
        ),
        Player(
            number = 5,
            role = Role.DOCTOR
        ),
        Player(
            number = 6,
            role = Role.COMMISSAR
        )
    )
    var canSwipe by remember { mutableStateOf(true) }
    MafiaMasterTheme {
        DistributionScreen(
            canSwipe = canSwipe,
            players = players
        )
    }
}