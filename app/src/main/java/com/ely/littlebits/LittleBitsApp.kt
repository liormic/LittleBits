package com.ely.littlebits

import android.app.Application
import android.content.Context
import com.ely.littlebits.di.AppModule
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.core.context.startKoin

class LittleBitsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        startKoin { modules(AppModule().getAppModule()) }
        Fresco.initialize(this);
    }

    companion object {
        @Volatile
        lateinit var appContext: Context
            private set
    }
}