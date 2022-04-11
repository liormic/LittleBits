package com.ely.littlebits

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "calories") val calories: String = ModelConsts.EMPTY_STRING,
    @ColumnInfo(name = "carbos") val carbos: String = ModelConsts.EMPTY_STRING,
    @ColumnInfo(name = "description") val description: String = ModelConsts.EMPTY_STRING,
    @ColumnInfo(name = "difficulty") val difficulty: Int = ModelConsts.DEFAULT_INT,
    @ColumnInfo(name = "fats") val fats: String = ModelConsts.EMPTY_STRING,
    @ColumnInfo(name = "headline") val headline: String = ModelConsts.EMPTY_STRING,
    @ColumnInfo(name = "image") val image: String = ModelConsts.EMPTY_STRING,
    @ColumnInfo(name = "name") val name: String = ModelConsts.EMPTY_STRING,
    @ColumnInfo(name = "proteins") val proteins: String = ModelConsts.EMPTY_STRING,
    @ColumnInfo(name = "thumb") val thumb: String = ModelConsts.EMPTY_STRING,
    @ColumnInfo(name = "time") val time: String = ModelConsts.EMPTY_STRING)