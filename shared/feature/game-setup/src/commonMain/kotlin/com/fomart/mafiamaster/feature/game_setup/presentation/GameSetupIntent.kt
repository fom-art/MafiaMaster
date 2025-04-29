package com.fomart.mafiamaster.feature.game_setup.presentation

sealed class GameSetupIntent {
    data class ChangePlayersAmount(val playersAmount: Int) : GameSetupIntent()
    object ToggleMistress : GameSetupIntent()
    object ToggleDoctor : GameSetupIntent()
    object ToggleManiac : GameSetupIntent()
    object ToggleCommissar : GameSetupIntent()
    object StartGame : GameSetupIntent()
    object GoBack : GameSetupIntent()
}
