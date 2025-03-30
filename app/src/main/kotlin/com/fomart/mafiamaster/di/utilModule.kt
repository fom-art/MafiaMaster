package com.fomart.mafiamaster.di

import com.diamondedge.logging.KmLog
import com.diamondedge.logging.logging
import org.koin.dsl.bind
import org.koin.dsl.module

val utilModule = module {
    single { logging("MafiaMaster") } bind KmLog::class
}
