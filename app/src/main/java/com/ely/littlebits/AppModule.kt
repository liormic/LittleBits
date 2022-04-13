package com.ely.littlebits

import androidx.room.Room
import com.ely.littlebits.Constants.DB_NAME
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