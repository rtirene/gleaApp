package com.example.glea

import android.app.Application
import androidx.paging.ExperimentalPagingApi
import com.example.glea.data.datamanager.di.appModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    @ExperimentalCoroutinesApi
    @ExperimentalPagingApi
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule))
        }
    }
}