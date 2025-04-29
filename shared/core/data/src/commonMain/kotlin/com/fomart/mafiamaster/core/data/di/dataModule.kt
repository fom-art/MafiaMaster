package com.fomart.mafiamaster.core.data.di

import com.fomart.mafiamaster.core.data.game.di.gameModule
import org.koin.dsl.module

val dataModule = module {
    includes(
        gameModule
    )
}