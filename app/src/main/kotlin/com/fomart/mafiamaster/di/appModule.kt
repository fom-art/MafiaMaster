package com.fomart.mafiamaster.di

import com.fomart.mafiamaster.core.data.di.dataModule
import org.koin.dsl.module

val appModule = module {
    includes(
        utilModule,
        dataModule,
        featureModule
    )
}