package com.fomart.mafiamaster.feature.game_setup.di

import com.fomart.mafiamaster.feature.game_setup.presentation.GameSetupViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val gameSetupModule = module {
    viewModel { GameSetupViewModel(get()) }
}