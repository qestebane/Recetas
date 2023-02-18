package com.elizabeth.recetarioapp.data.network

import com.elizabeth.recetarioapp.Core.RetrofitHelper
import com.elizabeth.recetarioapp.data.model.RecipeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RecipeService {
    //Servicio de internet
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getRecipes(): List<RecipeModel> {
        return withContext(Dispatchers.IO){
            val response : Response<List<RecipeModel> > = retrofit.create(RecipeApiClient::class.java).getAllListRecipes()
            response.body() ?: emptyList()
        }
    }

    suspend fun getSearchRecipes(name:String): List<RecipeModel> {
        return withContext(Dispatchers.IO){
            val response : Response<List<RecipeModel> > = retrofit.create(RecipeApiClient::class.java).getListRecipe(name)
            response.body() ?: emptyList()
        }
    }

    suspend fun getDetailRecipe(id:String): RecipeModel {
        return withContext(Dispatchers.IO){
            val response : Response<RecipeModel> = retrofit.create(RecipeApiClient::class.java).getDetailRecipe(id)
            response.body()!!
        }
    }
}