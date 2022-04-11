package com.ely.littlebits

import android.app.Application
import android.content.Context
import org.koin.core.context.startKoin
class LittleBitsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        startKoin { AppModule().getAppModule() }
    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }
}