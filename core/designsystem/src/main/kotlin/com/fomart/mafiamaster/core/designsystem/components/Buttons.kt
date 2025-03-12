package com.fomart.mafiamaster.core.designsystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.resources.R
import com.fomart.mafiamaster.core.designsystem.theme.MafiaMasterTheme

@Composable
fun CustomFilledButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    CustomFilledButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled
    ) {
        Text(
            modifier = Modifier
                .padding(
                    vertical = dimensionResource(id = R.dimen.padding_xsmall),
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                ),
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CustomFilledButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
    ) {
        content()
    }
}

@Preview
@Composable
fun CustomFilledButtonPreview() {
    var isEnabled by remember { mutableStateOf(true) }
    MafiaMasterTheme {
        CustomFilledButton(
            text = "Click me!",
            onClick = { isEnabled = !isEnabled },
            enabled = isEnabled
        )
    }
}