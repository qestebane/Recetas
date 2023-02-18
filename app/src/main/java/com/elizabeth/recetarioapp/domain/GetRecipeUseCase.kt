package com.elizabeth.recetarioapp.domain

import com.elizabeth.recetarioapp.data.RecipeRepository
import com.elizabeth.recetarioapp.data.model.RecipeModel

class GetRecipeUseCase {
    private val repository = RecipeRepository()
    suspend operator fun invoke():List<RecipeModel>?{
        return repository.getAllRecipes()
    }
}