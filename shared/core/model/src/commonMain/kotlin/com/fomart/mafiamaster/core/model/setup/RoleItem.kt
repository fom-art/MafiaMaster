package com.fomart.mafiamaster.core.model.setup

import org.jetbrains.compose.resources.Resource
import com.fomart.mafiamaster.core.utils.UiText
import org.jetbrains.compose.resources.DrawableResource

data class RoleItem(
    val title: UiText,
    val icon: DrawableResource,
    val count: Int? = null,
    val isSelected: Boolean,
    val onClick: (() -> Unit)? = null,
)
