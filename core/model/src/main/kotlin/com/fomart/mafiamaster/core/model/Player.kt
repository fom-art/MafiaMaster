package com.fomart.mafiamaster.core.model

data class Player(
    val number: Int,
    val role: Role,
    val foulsCount: Int = 0,
    val isAlive: Boolean = true
)