package com.fomart.mafiamaster.core.model.setup

data class RoleDistributionModel(
    val totalPlayers: Int,
    val mafiaCount: Int,
    val hasDon: Boolean,
    val hasMistress: Boolean = false,
    val hasDoctor: Boolean = false,
    val hasManiac: Boolean = false,
    val hasCommissar: Boolean = false,
)