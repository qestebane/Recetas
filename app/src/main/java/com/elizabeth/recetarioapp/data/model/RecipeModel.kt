package com.elizabeth.recetarioapp.data.model

import com.google.gson.annotations.SerializedName

data class RecipeModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String,
    )


  /*  @SerializedName("response") val response: String,
    @SerializedName("recipes") val recipes:List<RecipeItemResponse>
    )

data class RecipeItemResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String
)*/
