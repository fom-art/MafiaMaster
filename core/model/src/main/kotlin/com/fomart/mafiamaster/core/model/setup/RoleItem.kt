package com.fomart.mafiamaster.core.model.setup

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RoleItem(
    @StringRes val title: Int,
    @DrawableRes val icon:  Int,
    val count: Int? = null,
    val isSelected: Boolean,
    val onClick: (() -> Unit)? = null,
)
