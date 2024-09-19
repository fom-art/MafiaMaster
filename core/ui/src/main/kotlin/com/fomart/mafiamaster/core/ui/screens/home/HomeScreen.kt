package com.fomart.mafiamaster.core.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.ui.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.resources.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    goToGame: () -> Unit,
    goToRules: () -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier,
            text = stringResource(id = R.string.menu_play)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = { /*TODO*/ }) {

            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = { /*TODO*/ }) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MafiaMasterTheme {
        HomeScreen(
            goToGame = { },
            goToRules = {}
        )
    }
}