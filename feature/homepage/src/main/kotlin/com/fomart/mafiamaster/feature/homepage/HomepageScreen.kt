package com.fomart.mafiamaster.feature.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.designsystem.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.resources.R as commonResources

@Composable
fun HomepageScreen(
    modifier: Modifier = Modifier,
    goToGameSetup: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(commonResources.string.app_name),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.displayLarge
        )

        Button(
            onClick = goToGameSetup
        ) {
            Text(
                text = stringResource(commonResources.string.game_start),
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}

@Preview
@Composable
fun HomepageScreenPreview() {
    MafiaMasterTheme {
        HomepageScreen(
            goToGameSetup = {}
        )
    }
}