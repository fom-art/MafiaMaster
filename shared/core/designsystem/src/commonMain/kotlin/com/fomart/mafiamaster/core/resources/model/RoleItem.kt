package com.fomart.mafiamaster.core.resources.model

import com.fomart.mafiamaster.core.model.GameSetup
import com.fomart.mafiamaster.core.utils.UiText

import org.jetbrains.compose.resources.DrawableResource

data class RoleItem(
    val title: UiText,
    val icon: DrawableResource,
    val count: Int? = null,
    val isSelected: Boolean,
    val onClick: (() -> Unit)? = null,
)

