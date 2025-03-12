package com.fomart.mafiamaster.core.designsystem.screens.home

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.designsystem.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.designsystem.components.CustomFilledButton

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    goToGame: () -> Unit,
    goToRules: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            CustomFilledButton(
                modifier = Modifier
                    .padding(end = dimensionResource(R.dimen.padding_small))
                    .weight(1f),
                onClick = goToGame,
                text = stringResource(id = R.string.menu_play)
            )
            CustomFilledButton(
                modifier = Modifier
                    .padding(start = dimensionResource(R.dimen.padding_small))
                    .weight(1f),
                onClick = goToRules,
                text = stringResource(id = R.string.menu_rules)
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun HomeScreenPreview() {
    MafiaMasterTheme {
        HomeScreen(
            goToGame = { },
            goToRules = {}
        )
    }
}