package com.example.engway

import android.app.Application
import com.example.livekoin.di.modules.apiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@AppApplication)
            modules(apiModule)
        }

    }
}