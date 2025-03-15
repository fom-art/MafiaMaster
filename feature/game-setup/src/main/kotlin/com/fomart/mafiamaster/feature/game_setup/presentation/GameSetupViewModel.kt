package com.fomart.mafiamaster.feature.game_setup.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameSetupViewModel : ViewModel() {
    var state by mutableStateOf(GameSetupState())
        private set

    fun onAction(action: GameSetupIntent) {
        when (action) {
            is GameSetupIntent.ChangePlayersAmount -> changePlayersAmount(action.playersAmount)
            GameSetupIntent.ToggleMistress -> toggleMistress()
            GameSetupIntent.ToggleDoctor -> toggleDoctor()
            GameSetupIntent.ToggleManiac -> toggleManiac()
            GameSetupIntent.ToggleCommissar -> toggleCommissar()
            else -> {}
        }
    }

    private fun changePlayersAmount(playersAmount: Int) {
        val hasDon = playersAmount >= 9
        val mafiaCount = playersAmount / 3 - hasDon.toInt() - state.hasMistress.toInt()
        state = state.copy(
            totalPlayers = playersAmount,
            hasDon = hasDon,
            mafiaCount = mafiaCount
        )
    }

    private fun toggleMistress() {
        state = state.copy(hasMistress = !state.hasMistress)
        changePlayersAmount(state.totalPlayers) // Recalculate mafia count
    }

    private fun toggleDoctor() {
        state = state.copy(hasDoctor = !state.hasDoctor)
    }

    private fun toggleManiac() {
        state = state.copy(hasManiac = !state.hasManiac)
    }

    private fun toggleCommissar() {
        state = state.copy(hasCommissar = !state.hasCommissar)
    }
}
