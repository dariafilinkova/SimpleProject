package com.simpleproject.simpleproject.app

import android.app.Application
import com.simpleproject.simpleproject.di.appModule
import com.simpleproject.simpleproject.di.dataModule
import com.simpleproject.simpleproject.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() { // should be written in Manifest
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG) // говорит насколько сильно логировать ошибки
            androidContext(this@App) // will be used in data module(application context)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}