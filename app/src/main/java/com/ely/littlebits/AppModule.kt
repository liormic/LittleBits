package com.ely.littlebits

import androidx.room.Room
import org.koin.dsl.module

class AppModule {

    fun getAppModule() {
        val appModule = module {
                fun provideDB(): AppDB {
                    return Room.databaseBuilder(
                        LittleBitsApp.appContext,
                        AppDB::class.java, "app-db"
                    ).build()
                }

                single { provideDB() }
                single {
                    val database = get<AppDB>()
                    database.recipesDao()
                }
        }
    }
}