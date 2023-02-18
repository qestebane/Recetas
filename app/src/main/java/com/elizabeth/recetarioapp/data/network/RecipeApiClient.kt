package com.elizabeth.recetarioapp.data.network

import com.elizabeth.recetarioapp.data.model.RecipeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeApiClient {
    @GET("/api/v1/recipe")
    suspend fun getAllListRecipes(): Response<List<RecipeModel>>

    @GET("/api/v1/recipe")
    suspend fun getListRecipe(@Query("name") name:String): Response<List<RecipeModel>>

    @GET("/api/v1/recipe/{id}")
    suspend fun getDetailRecipe(@Path("id") id:String): Response<RecipeModel>
}