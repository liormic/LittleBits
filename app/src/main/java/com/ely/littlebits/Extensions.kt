package com.ely.littlebits

import android.view.View
import android.widget.TextView
import com.ely.littlebits.Constants.DEFAULT_INT

fun TextView.setTextOrGone(text: String?) {
    this.visibility = if (text.isNullOrBlank()) View.GONE else View.VISIBLE
    this.text = text
}

fun String?.toIntOrDefault(default: Int = DEFAULT_INT): Int {
    return try {
        this?.toInt() ?: default
    } catch (exception: NumberFormatException) {
        default
    }
}

