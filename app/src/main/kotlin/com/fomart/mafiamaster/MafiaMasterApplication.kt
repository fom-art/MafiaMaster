package com.fomart.mafiamaster

import android.app.Application
import com.fomart.mafiamaster.di.initKoin
import org.koin.androix.startup.KoinStartup.onKoinStartup
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
class MafiaMasterApplication: Application() {
    init {
        onKoinStartup {
            initKoin(context = applicationContext)
        }
    }
}