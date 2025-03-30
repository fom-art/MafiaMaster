package com.fomart.mafiamaster.core.data.game.di

import com.fomart.mafiamaster.core.data.game.GameRepositoryImpl
import com.fomart.mafiamaster.core.data.game.domain.GameRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val gameModule = module {
    single { GameRepositoryImpl(get()) } bind GameRepository::class
}