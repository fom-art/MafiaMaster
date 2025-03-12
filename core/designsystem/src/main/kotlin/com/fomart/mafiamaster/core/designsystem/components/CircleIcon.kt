package com.fomart.mafiamaster.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import com.fomart.mafiamaster.core.resources.R

@Composable
fun CircleIcon(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.onSecondary,
    iconColor: Color = MaterialTheme.colorScheme.secondary,
    painter: Painter
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(dimensionResource(id = R.dimen.icon_size_large))
        ,
    ) {
        Box(
            modifier = Modifier.background(backgroundColor),
        ) {
            Icon(
                modifier = Modifier
                    .padding(all = dimensionResource(id = R.dimen.padding_small)),
                painter = painter,
                tint = iconColor,
                contentDescription = ""
            )
        }
    }
}