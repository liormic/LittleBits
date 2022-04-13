package com.ely.littlebits

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivityViewModel(private val mainActivityRepository: MainActivityRepository) :
    ViewModel() {

    val recipesMutableLiveData = MutableLiveData<List<Recipe>>()

    fun insertRecipes() {
        viewModelScope.launch {
            mainActivityRepository.insertRecipes(readJsonFile())
        }
    }

    fun getAllRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            mainActivityRepository.getAllRecipes().collect {
                recipesMutableLiveData.postValue(it)
            }
        }
    }

    private fun readJsonFile(): MutableList<Recipe> {
        val jsonFile =
            LittleBitsApp.appContext.assets.open(Constants.JSON_FILE_NAME).bufferedReader()
                .use { it.readText() }
        if (jsonFile.isNotEmpty()) {
            return GsonBuilder().serializeNulls().create().fromJson(jsonFile, Recipes::class.java).recipes
        }
        return mutableListOf()
    }
}