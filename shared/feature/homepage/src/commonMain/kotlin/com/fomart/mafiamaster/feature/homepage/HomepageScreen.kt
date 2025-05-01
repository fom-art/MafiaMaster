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
import com.fomart.mafiamaster.core.resources.theme.MafiaMasterTheme
import mafiamaster.shared.feature.homepage.generated.resources.Res
import mafiamaster.shared.feature.homepage.generated.resources.app_name
import mafiamaster.shared.feature.homepage.generated.resources.game_start
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomepageScreen(
    modifier: Modifier = Modifier,
    goToGameSetup: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
//            .background(MaterialTheme.colorScheme.background)
        ,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.app_name),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.displayLarge
        )

        Button(
            onClick = goToGameSetup
        ) {
            Text(
                text = stringResource(Res.string.game_start),
                style = MaterialTheme.typography.displayMedium
            )
        }
    }
}