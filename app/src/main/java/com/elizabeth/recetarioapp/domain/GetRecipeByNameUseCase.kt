package com.elizabeth.recetarioapp.domain;

import com.elizabeth.recetarioapp.data.RecipeRepository
import com.elizabeth.recetarioapp.data.model.RecipeModel

class GetRecipeByNameUseCase {
    private val repository = RecipeRepository()

    suspend operator fun invoke(filter: String): List<RecipeModel>?{
        return repository.getRecipesOnQuery(filter)
    }
}
