package com.example.kmmnoteapp.android

import android.app.Application
import com.example.kmmnoteapp.androidModule
import com.example.kmmnoteapp.android.di.appModule
import com.example.kmmnoteapp.di.commonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(commonModule(), appModule, androidModule(this@App))
        }
    }
}
