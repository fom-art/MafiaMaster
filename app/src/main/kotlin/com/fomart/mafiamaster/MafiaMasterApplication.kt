package com.fomart.mafiamaster

import android.app.Application
import com.fomart.mafiamaster.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androix.startup.KoinStartup.onKoinStartup
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.logger.Level.DEBUG

@OptIn(KoinExperimentalAPI::class)
class MafiaMasterApplication : Application() {
    init {
        onKoinStartup {
//            initKoin(applicationContext)
            androidContext(this@MafiaMasterApplication)
            androidLogger(DEBUG)
            modules(appModule)
            printLogger()
////            workManagerFactory()
        }
    }
}