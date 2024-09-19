package com.fomart.mafiamaster.feature.game_setup

import androidx.annotation.DrawableRes

data class RoleItemData(
    val name: String,
    val count: Int,
    @DrawableRes val iconDrawableRes: Int,
    val onAddClicked: (() -> Unit)? = null,
    val onRemoveClicked: (() -> Unit)? = null,
)