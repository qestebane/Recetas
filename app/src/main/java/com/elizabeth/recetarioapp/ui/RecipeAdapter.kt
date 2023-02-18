package com.elizabeth.recetarioapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elizabeth.recetarioapp.R
import com.elizabeth.recetarioapp.data.model.RecipeModel

class RecipeAdapter(var recipeList: List<RecipeModel> = emptyList(),
    private val onItemSelected: (String) -> Unit
 ):
RecyclerView.Adapter<RecipeViewHolder>(){
    fun updateListRecipe(recipeList: List<RecipeModel>){
        this.recipeList = recipeList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipeList[position],onItemSelected)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }
}