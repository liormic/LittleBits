package com.ely.littlebits

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : AppCompatActivity(), KoinComponent {
    private val mainActivityViewModel: MainActivityViewModel by viewModel()
    private lateinit var rv :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)
        mainActivityViewModel.insertRecipes()

        mainActivityViewModel.recipesMutableLiveData.observe(this, { recpiesList ->
            initRv(recpiesList)
        })
        mainActivityViewModel.getAllRecipes()
    }

    private fun initRv(recipesList: List<Recipe>) {
        rv.also {
            it.layoutManager = LinearLayoutManager(this)
            it.setHasFixedSize(true)
            it.adapter = RecipesAdapter(recipesList)
        }
    }
}