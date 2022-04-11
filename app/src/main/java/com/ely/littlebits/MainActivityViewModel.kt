package com.ely.littlebits

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActivityViewModel(private val mainActivityRepository: MainActivityRepository) : ViewModel() {
    fun insertRecipes(recipes: List<Recipe>) {
        viewModelScope.launch {
            mainActivityRepository.insertRecipes(recipes)
        }
    }
}