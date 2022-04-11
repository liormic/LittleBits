package com.ely.littlebits

class MainActivityRepository(private val recipesDao : RecipesDao) {
    suspend fun insertRecipes(recipes : List<Recipe>) {
        recipesDao.insert(recipes)
    }
}