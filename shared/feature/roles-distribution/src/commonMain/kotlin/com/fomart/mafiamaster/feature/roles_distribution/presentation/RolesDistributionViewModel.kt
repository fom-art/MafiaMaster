package com.fomart.mafiamaster.feature.roles_distribution.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fomart.mafiamaster.core.data.game.domain.GameRepository

class RolesDistributionViewModel(
    private val gameRepository: GameRepository
) : ViewModel() {
    var canSwipe by mutableStateOf(false)
        private set
    var players = gameRepository.gameState.value!!.players
}