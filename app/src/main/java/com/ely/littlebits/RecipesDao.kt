package com.ely.littlebits

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
 interface RecipesDao {
    @Query("SELECT * FROM recipe")
    fun getAll(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE id LIKE :id")
    fun findById(id: String): Flow<Recipe>

    @Insert(onConflict = IGNORE)
   suspend fun insert( recipe: List<Recipe>)

    @Delete
    fun delete(recipe: Recipe)
}