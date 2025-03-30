package com.fomart.mafiamaster.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level.DEBUG

fun KoinApplication.initKoin(context: Context) {
    androidContext(context)
    androidLogger(DEBUG)
    modules(appModule)
    printLogger()
}