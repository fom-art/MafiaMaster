package com.fomart.mafiamaster

import android.app.Application
import com.fomart.mafiamaster.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level.DEBUG

class MafiaMasterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            initKoin(applicationContext)
            androidContext(this@MafiaMasterApplication)
            androidLogger(DEBUG)
            modules(appModule)
            printLogger()
        }
    }
}