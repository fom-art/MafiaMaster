package com.fomart.mafiamaster.core.data.game.domain

import com.fomart.mafiamaster.core.data.core.EmptyResult
import com.fomart.mafiamaster.core.model.Game
import com.fomart.mafiamaster.core.model.GameSetup
import kotlinx.coroutines.flow.StateFlow

interface GameRepository {
    val gameState: StateFlow<Game?>
    fun createGame(gameSetup: GameSetup): EmptyResult<GameCreationError>
}