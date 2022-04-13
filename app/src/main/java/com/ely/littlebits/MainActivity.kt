package com.ely.littlebits

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent


class MainActivity : AppCompatActivity(), KoinComponent {
    private val mainActivityViewModel: MainActivityViewModel by viewModel()
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)
        mainActivityViewModel.insertRecipes()
        mainActivityViewModel.recipesMutableLiveData.observe(this, { recipesList ->
            initRv(recipesList)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.sort_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val recipesList = mainActivityViewModel.recipesMutableLiveData.value
        when (item.itemId) {

            R.id.calories -> {
                //Setting the adapter again to clear previous results
                rv.adapter = recipesList?.let { RecipesAdapter(it) }
                rv.adapter = recipesList?.let {
                    RecipesAdapter(recipesList.sortedByDescending { sCalories ->
                        sCalories.calories?.filter { it.isDigit() }?.toIntOrDefault()
                    }
                    )
                }
            }

            R.id.carbs -> {
                rv.adapter = recipesList?.let { RecipesAdapter(it) }
                rv.adapter = recipesList?.let {
                    RecipesAdapter(recipesList.sortedByDescending { sCarbs ->
                        sCarbs.carbos?.filter { it.isDigit() }?.toIntOrDefault()
                    }
                    )
                }
            }

            R.id.fats -> {
                rv.adapter = recipesList?.let { RecipesAdapter(it) }
                rv.adapter = recipesList?.let {
                    RecipesAdapter(recipesList.sortedByDescending { sFats ->
                        sFats.fats?.filter {
                            it.isDigit()
                        }?.toIntOrDefault()
                    })
                }
            }

            R.id.proteins -> {
                rv.adapter = recipesList?.let { RecipesAdapter(it) }
                rv.adapter = recipesList?.let {
                    RecipesAdapter(recipesList.sortedByDescending { sProteins ->
                        sProteins.proteins?.filter { it.isDigit() }?.toIntOrDefault()
                    }
                    )
                }
            }

            R.id.time -> {
                rv.adapter = recipesList?.let { RecipesAdapter(it) }
                rv.adapter = recipesList?.let {
                    RecipesAdapter(recipesList.sortedByDescending { sTime ->
                        sTime.time?.filter { it.isDigit() }?.toIntOrDefault()
                    })
                }
            }

            R.id.difficulty -> {
                rv.adapter = recipesList?.let { RecipesAdapter(it) }
                rv.adapter = recipesList?.let {
                    RecipesAdapter(recipesList.sortedByDescending { sDifficulty -> sDifficulty.difficulty }
                    )
                }
            }
        }
        rv.invalidate()
        return false
    }

}