package com.ely.littlebits

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ely.littlebits.LittleBitsApp.Companion.appContext
import com.ely.littlebits.model.Recipe
import com.facebook.drawee.view.SimpleDraweeView


class RecipesAdapter(private val recipes: List<Recipe>) :
    RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.name)
        val tvTime: TextView = view.findViewById(R.id.time)
        val tvCalories: TextView = view.findViewById(R.id.calories)
        val tvDifficulty: TextView = view.findViewById(R.id.difficulty)
        val tvHeadline: TextView = view.findViewById(R.id.headline)
        val tvCarbs: TextView = view.findViewById(R.id.carbs)
        val tvFats: TextView = view.findViewById(R.id.fats)
        val tvProteins: TextView = view.findViewById(R.id.proteins)
        val tvDescription: TextView = view.findViewById(R.id.description)
        val tvCountry: TextView = view.findViewById(R.id.country)
        val ivDraweeView: SimpleDraweeView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item_layout, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.tvName.setTextOrGone(recipes[position].name)
        viewHolder.tvTime.setTextOrGone(recipes[position].time)
        viewHolder.tvCountry.setTextOrGone(recipes[position].country)
        viewHolder.tvHeadline.setTextOrGone(recipes[position].headline)
        viewHolder.tvDescription.setTextOrGone(recipes[position].description)

        (appContext.getString(R.string.carbs) + recipes[position].carbos).also {
            viewHolder.tvCarbs.text = it
        }
        (appContext.getString(R.string.fats) + recipes[position].fats).also {
            viewHolder.tvFats.text = it
        }
        (appContext.getString(R.string.proteins) + recipes[position].proteins).also {
            viewHolder.tvProteins.text = it
        }

        (appContext.getString(R.string.difficulty) + recipes[position].difficulty.toString()).also {
            viewHolder.tvDifficulty.text = it
        }

        (appContext.getString(R.string.calories) + recipes[position].calories).also {
            viewHolder.tvCalories.text = it
        }

        viewHolder.ivDraweeView.setImageURI(recipes[position].image)
    }

    override fun getItemCount() = recipes.size
}
