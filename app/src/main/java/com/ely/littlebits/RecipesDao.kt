package com.ely.littlebits

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {
    @Query("SELECT * FROM recipe")
    fun getAll(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE id LIKE :id")
    fun findById(id: String): Flow<Recipe>

    @Insert
    suspend fun insert(vararg recipe: Recipe)

    @Delete
    suspend fun delete(recipe: Recipe)
}