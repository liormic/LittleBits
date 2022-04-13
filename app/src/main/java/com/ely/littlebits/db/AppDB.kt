package com.ely.littlebits.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ely.littlebits.model.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun recipesDao(): RecipesDao
}