package com.ely.littlebits

import kotlinx.coroutines.flow.Flow

class MainActivityRepository(private val recipesDao: RecipesDao) {
    suspend fun insertRecipes(recipes: List<Recipe>) {
        recipesDao.insert(recipes)
    }

     fun getAllRecipes(): Flow<List<Recipe>> {
        return recipesDao.getAll()
    }
}