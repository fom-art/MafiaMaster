package com.fomart.mafiamaster.core.model

class Game(
    val players: List<Player>,
    val event: GameEvent = GameEvent.RolesDistribution
)