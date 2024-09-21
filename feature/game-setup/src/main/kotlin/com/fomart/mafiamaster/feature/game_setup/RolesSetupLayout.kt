package com.fomart.mafiamaster.feature.game_setup

import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.fomart.mafiamaster.core.ui.theme.MafiaMasterTheme
import com.fomart.mafiamaster.core.resources.R


@Composable
fun RolesSetupLayout(
    modifier: Modifier = Modifier,
    roleItemsData: List<RoleItemData>
) {
    LazyColumn(modifier = modifier) {
        items(roleItemsData) { roleItemData ->
            RoleItemRow(roleItemData = roleItemData)
        }
    }
}

@Composable
fun RoleItemRow(
    modifier: Modifier = Modifier,
    roleItemData: RoleItemData
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        
    ) {

    }
}

@Preview
@Composable
fun RolesSetupLayoutPreview() {
    val context = LocalContext.current
    val playerRoleItemData = RoleItemData(
        name = "Players",
        count = 12,
        iconDrawableRes = R.drawable.ic_civillian,
        onAddClicked = { Toast.makeText(context, "Player added", Toast.LENGTH_SHORT).show() },
        onRemoveClicked = { Toast.makeText(context, "Player removed", Toast.LENGTH_SHORT).show() }
    )
    val mafiaRoleItemData = RoleItemData(
        name = "Mafia",
        count = 2,
        iconDrawableRes = R.drawable.ic_civillian,
        onAddClicked = { Toast.makeText(context, "Mafia added", Toast.LENGTH_SHORT).show() },
        onRemoveClicked = { Toast.makeText(context, "Mafia removed", Toast.LENGTH_SHORT).show() }
    )
    val mistressRoleItemData = RoleItemData(
        name = "Mistress",
        count = 1,
        iconDrawableRes = R.drawable.ic_civillian,
        onAddClicked = { Toast.makeText(context, "Mistress added", Toast.LENGTH_SHORT).show() },
        onRemoveClicked = { Toast.makeText(context, "Mistress removed", Toast.LENGTH_SHORT).show() }
    )
    val donRoleItemData = RoleItemData(
        name = "Don",
        count = 1,
        iconDrawableRes = R.drawable.ic_civillian,
    )
    val doctorRoleItemData = RoleItemData(
        name = "Doctor",
        count = 1,
        iconDrawableRes = R.drawable.ic_civillian,
        onAddClicked = { Toast.makeText(context, "Doctor added", Toast.LENGTH_SHORT).show() },
        onRemoveClicked = { Toast.makeText(context, "Doctor removed", Toast.LENGTH_SHORT).show() }
    )
    val commissarRoleItemData = RoleItemData(
        name = "Commissar",
        count = 1,
        iconDrawableRes = R.drawable.ic_civillian,
        onAddClicked = { Toast.makeText(context, "Commissar added", Toast.LENGTH_SHORT).show() },
        onRemoveClicked = {
            Toast.makeText(context, "Commissar removed", Toast.LENGTH_SHORT).show()
        }
    )
    val maniacRoleItemData = RoleItemData(
        name = "Maniac",
        count = 1,
        iconDrawableRes = R.drawable.ic_civillian,
        onAddClicked = { Toast.makeText(context, "Maniac added", Toast.LENGTH_SHORT).show() },
        onRemoveClicked = { Toast.makeText(context, "Maniac removed", Toast.LENGTH_SHORT).show() }
    )

    MafiaMasterTheme {
        RolesSetupLayout(
            roleItemsData = listOf(
                playerRoleItemData,
                mafiaRoleItemData,
                mistressRoleItemData,
                donRoleItemData,
                doctorRoleItemData,
                commissarRoleItemData,
                maniacRoleItemData
            )
        )
    }
}