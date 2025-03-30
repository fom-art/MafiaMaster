package com.fomart.mafiamaster.core.data.game

import com.diamondedge.logging.KmLog
import com.fomart.mafiamaster.core.data.core.EmptyResult
import com.fomart.mafiamaster.core.data.core.Result
import com.fomart.mafiamaster.core.data.game.domain.GameCreationError
import com.fomart.mafiamaster.core.data.game.domain.GameRepository
import com.fomart.mafiamaster.core.model.Game
import com.fomart.mafiamaster.core.model.GameSetup
import com.fomart.mafiamaster.core.model.Player
import com.fomart.mafiamaster.core.model.Role
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class GameRepositoryImpl(
    private val logger: KmLog
) : GameRepository {
    private val _gameState: MutableStateFlow<Game?> = MutableStateFlow(null)
    override val gameState: StateFlow<Game?> get() = _gameState

    override fun createGame(gameSetup: GameSetup): EmptyResult<GameCreationError> {
        _gameState.update {
            generateGame(gameSetup)
        }
        return Result.Success(Unit)
    }

    fun generateGame(setup: GameSetup): Game {
        val totalPlayers = setup.totalPlayers
        val roles = mutableListOf<Role>()

        // Add mafia roles
        if (setup.hasDon) roles.add(Role.Don())
        if (setup.hasMistress) roles.add(Role.Mistress())
        repeat(setup.mafiaCount) {
            roles.add(Role.Mafia())
        }

        // Add active civilian roles
        if (setup.hasCommissar) roles.add(Role.Commissar())
        if (setup.hasDoctor) roles.add(Role.Doctor())
        if (setup.hasManiac) roles.add(Role.Maniac())

        // Fill the rest with civilians
        val civilianCount = totalPlayers - roles.size
        repeat(civilianCount) {
            roles.add(Role.Civilian())
        }

        roles.shuffle()

        val players = roles.mapIndexed { index, role ->
            Player(number = index + 1, role = role)
        }

        // Logging the result
        logger.info { "=== Game Setup ===" }
        players.forEach { player ->
            logger.info { "Player #${player.number}: ${player.role::class.simpleName}" }
        }

        return Game(players)
    }
}