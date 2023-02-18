package com.elizabeth.recetarioapp.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.elizabeth.recetarioapp.data.model.RecipeModel
import com.elizabeth.recetarioapp.databinding.ItemRecipeBinding
import com.squareup.picasso.Picasso

class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemRecipeBinding.bind(view)
    fun bind(recipeItemResponse: RecipeModel, onItemSelected:(String) -> Unit){
        binding.tvRecipeName.text = recipeItemResponse.name

        Picasso.get().load(recipeItemResponse.image).into(binding.image)
        binding.root.setOnClickListener{onItemSelected(recipeItemResponse.id)}
    }



}