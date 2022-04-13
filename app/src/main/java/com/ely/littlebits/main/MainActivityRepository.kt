package com.ely.littlebits.main

import com.ely.littlebits.model.Recipe
import com.ely.littlebits.db.RecipesDao
import kotlinx.coroutines.flow.Flow

class MainActivityRepository(private val recipesDao: RecipesDao) {
    suspend fun insertRecipes(recipes: List<Recipe>) {
        recipesDao.insert(recipes)
    }

     fun getAllRecipes(): Flow<List<Recipe>> {
        return recipesDao.getAll()
    }
}