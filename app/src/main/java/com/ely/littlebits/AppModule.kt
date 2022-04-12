package com.ely.littlebits

import androidx.room.Room
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class AppModule {

    fun getAppModule(): Module {
        val appModule = module {
            fun provideDB(): AppDB {
                return Room.databaseBuilder(
                    LittleBitsApp.appContext,
                    AppDB::class.java, "app-db"
                ).build()
            }

            single { provideDB() }
//            single {
//                val database = provideDB()
//                database.recipesDao()
//            }

            single {
                val database = get<AppDB>()
                database.recipesDao()
            }

            single {
                MainActivityRepository(get())
            }

            viewModel { MainActivityViewModel(get()) }
        }
        return appModule
    }
}