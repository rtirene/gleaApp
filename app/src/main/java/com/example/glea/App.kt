package com.example.glea

import android.app.Application
import com.example.glea.data.datamanager.di.databaseModule
import com.example.glea.data.datamanager.di.mapperModule
import com.example.glea.data.datamanager.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(databaseModule, networkModule, mapperModule))
        }
    }
}