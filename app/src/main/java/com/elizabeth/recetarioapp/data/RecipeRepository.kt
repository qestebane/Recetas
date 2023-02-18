package com.elizabeth.recetarioapp.data

import com.elizabeth.recetarioapp.data.model.RecipeModel
import com.elizabeth.recetarioapp.data.model.RecipeProvider
import com.elizabeth.recetarioapp.data.network.RecipeService

class RecipeRepository {

    private val api = RecipeService()

    suspend fun getAllRecipes(): List<RecipeModel>{
        val response = api.getRecipes()
        RecipeProvider.recipes = response
        return response
    }

    suspend fun getItemRecipe(query: String): RecipeModel{
        val response = api.getDetailRecipe(query)
        RecipeProvider.recipes = listOf(response)
        return response
    }
    suspend fun getRecipesOnQuery(query: String): List<RecipeModel>{
        val response = api.getSearchRecipes(query)
        RecipeProvider.recipes = response
        return response
    }
}