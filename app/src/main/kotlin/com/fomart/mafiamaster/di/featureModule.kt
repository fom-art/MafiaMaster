package com.fomart.mafiamaster.di

import com.fomart.mafiamaster.feature.game_setup.di.gameSetupModule
import com.fomart.mafiamaster.feature.roles_distribution.di.rolesDistributionModule
import org.koin.dsl.module

val featureModule = module {
    includes(
        gameSetupModule,
        rolesDistributionModule
    )
}