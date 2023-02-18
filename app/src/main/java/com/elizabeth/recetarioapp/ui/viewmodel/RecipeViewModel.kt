package com.elizabeth.recetarioapp.ui.viewmodel

import androidx.lifecycle.*
import com.elizabeth.recetarioapp.data.RecipeRepository
import com.elizabeth.recetarioapp.data.model.RecipeModel
import com.elizabeth.recetarioapp.data.model.RecipeProvider
import com.elizabeth.recetarioapp.domain.GetFilterRecipeUseCase
import com.elizabeth.recetarioapp.domain.GetRecipeByNameUseCase
import com.elizabeth.recetarioapp.domain.GetRecipeUseCase
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {


     val recipeModel = MutableLiveData<List<RecipeModel>>()
    //val _recipeModel: LiveData<List<RecipeModel>> = recipeModel


    //progressBar
    var isLoading = MutableLiveData<Boolean>()

    val ItemRecipeModel = MutableLiveData<RecipeModel>()

    //Call useCase
    var getRecipeUseCase = GetRecipeUseCase()
    var getFilterRecipeUseCase = GetFilterRecipeUseCase()
    var getRecipeByNameUseCase = GetRecipeByNameUseCase()

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)


    fun onCreate() {
        isLoading.postValue(true)
        viewModelScope.launch {
            val result = getRecipeUseCase()

            if (!result.isNullOrEmpty()){
                recipeModel.postValue(result!!)
                isLoading.postValue(false)
            }
            val result2 = ItemRecipeModel
        }
    }
    suspend fun searchRecipe(query: String){
        val myresult = getFilterRecipeUseCase.invoke(query)
        if (myresult != null) {
            ItemRecipeModel.postValue(myresult!!)
            }
    }

    companion object{
        private const val DEFAULT_QUERY = "1"
    }

    suspend fun searchRecipeByName(query: String){

        isLoading.postValue(true)

        val recipe = getRecipeByNameUseCase(query)
        if (recipe!=null){
           recipeModel.postValue(recipe!!)
        }
        isLoading.postValue(false)
    }

}