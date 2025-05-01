package com.fomart.mafiamaster.core.model

data class GameSetup(
    val totalPlayers: Int = 0,
    val hasDon: Boolean = false,
    val mafiaCount: Int = 0,
    val hasMistress: Boolean = false,
    val hasDoctor: Boolean = false,
    val hasManiac: Boolean = false,
    val hasCommissar: Boolean = false
)