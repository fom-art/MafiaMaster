package com.fomart.mafiamaster.core.model.setup

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick

data class RoleItem(
    @StringRes val title: Int,
    @DrawableRes val icon:  Int,
    val count: Int? = null,
    val isSelected: Boolean,
    val onClick: (() -> Unit)? = null,
)
