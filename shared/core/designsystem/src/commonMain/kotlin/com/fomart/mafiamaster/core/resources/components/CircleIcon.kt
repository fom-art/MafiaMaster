package com.fomart.mafiamaster.core.resources.components

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CircleIcon(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.onSecondary,
    iconColor: Color = MaterialTheme.colorScheme.secondary,
    imageVector: ImageVector
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(64.dp)
        ,
    ) {
        Box(
            modifier = Modifier.background(backgroundColor),
        ) {
            Icon(
                modifier = Modifier
                    .padding(all = 8.dp),
                imageVector =  imageVector,
                tint = iconColor,
                contentDescription = ""
            )
        }
    }
}