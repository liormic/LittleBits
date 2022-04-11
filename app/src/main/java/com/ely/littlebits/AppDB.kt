package com.ely.littlebits

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Recipe::class], version = 1)
abstract class AppDB : RoomDatabase() {

    abstract fun recipesDao(): RecipesDao

}