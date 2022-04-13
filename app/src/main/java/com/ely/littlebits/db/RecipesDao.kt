package com.ely.littlebits.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.ely.littlebits.model.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {
    @Query("SELECT * FROM recipe")
    fun getAll(): Flow<List<Recipe>>

    @Insert(onConflict = IGNORE)
    suspend fun insert(recipe: List<Recipe>)
}