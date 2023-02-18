package com.elizabeth.recetarioapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.elizabeth.recetarioapp.R
import com.elizabeth.recetarioapp.data.model.RecipeModel
import com.elizabeth.recetarioapp.data.model.RecipeProvider
import com.elizabeth.recetarioapp.databinding.ActivityDetailRecipeBinding
import com.elizabeth.recetarioapp.ui.viewmodel.RecipeViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailRecipeActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "extra_id"
    }
    private lateinit var binding: ActivityDetailRecipeBinding
    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recipeViewModel.onCreate()

        val id: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getRecipeInformation(id)

        recipeViewModel.ItemRecipeModel.observe(this, Observer { recipes ->

            Log.i("message","it pass")
        })
    }

    private fun getRecipeInformation(id: String) {

        CoroutineScope(Dispatchers.IO).launch {
            recipeViewModel.searchRecipe(id)

            val recipeDetail = recipeViewModel.ItemRecipeModel
            //recipeItemResponse
            runOnUiThread {
                createUI(recipeDetail.value!!)
            }
        }
    }

    private fun createUI(body: RecipeModel) {
        Picasso.get().load(body.image).into(binding.ivRecipe)
        binding.tvRecipeName.text = body.name
        binding.tvDescription.text = body.description

    }
}