package com.fomart.mafiamaster.core.model

sealed class GameEvent {
    object RolesDistribution: GameEvent()
    object MafiaIntroductionNight: GameEvent()
    object Talk: GameEvent()
    object Speeches: GameEvent()
    object Voting: GameEvent()
    object Night: GameEvent()
}