package com.ely.littlebits.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ely.littlebits.Constants.DEFAULT_INT
import com.ely.littlebits.Constants.STRING_NA

@Entity
data class Recipe(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "calories") var calories: String? = STRING_NA,
    @ColumnInfo(name = "carbos") val carbos: String? = STRING_NA,
    @ColumnInfo(name = "description") val description: String? = STRING_NA,
    @ColumnInfo(name = "difficulty") val difficulty: Int? = DEFAULT_INT,
    @ColumnInfo(name = "fats") val fats: String? = STRING_NA,
    @ColumnInfo(name = "headline") val headline: String? = STRING_NA,
    @ColumnInfo(name = "image") val image: String? = STRING_NA,
    @ColumnInfo(name = "name") val name: String? = STRING_NA,
    @ColumnInfo(name = "proteins") var proteins: String? = STRING_NA,
    @ColumnInfo(name = "thumb") val thumb: String? = STRING_NA,
    @ColumnInfo(name = "time") var time: String? = STRING_NA,
    @ColumnInfo(name = "country") val country: String? = STRING_NA
)



