package com.elizabeth.recetarioapp.domain

import com.elizabeth.recetarioapp.data.RecipeRepository
import com.elizabeth.recetarioapp.data.model.RecipeModel


class GetFilterRecipeUseCase() {
    private val repository = RecipeRepository()

    //RecipeModel
    suspend operator fun invoke(id: String): RecipeModel?{
        return repository.getItemRecipe(id)
    }


}
