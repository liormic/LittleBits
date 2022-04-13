package com.ely.littlebits.di

import androidx.room.Room
import com.ely.littlebits.Constants.DB_NAME
import com.ely.littlebits.LittleBitsApp
import com.ely.littlebits.main.MainActivityRepository
import com.ely.littlebits.main.MainActivityViewModel
import com.ely.littlebits.db.AppDB
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class AppModule {
    /**
     * Method to build dependencies for DI module
     */
    fun getAppModule(): Module {
        val appModule = module {
            fun provideDB(): AppDB {
                return Room.databaseBuilder(
                    LittleBitsApp.appContext,
                    AppDB::class.java, DB_NAME
                ).build()
            }

            single { provideDB() }
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