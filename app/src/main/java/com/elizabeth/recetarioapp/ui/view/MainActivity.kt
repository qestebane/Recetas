package com.elizabeth.recetarioapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.elizabeth.recetarioapp.data.RecipeRepository
import com.elizabeth.recetarioapp.data.model.RecipeModel
import com.elizabeth.recetarioapp.data.network.RecipeService
import com.elizabeth.recetarioapp.databinding.ActivityMainBinding
import com.elizabeth.recetarioapp.domain.GetFilterRecipeUseCase
import com.elizabeth.recetarioapp.ui.RecipeAdapter
import com.elizabeth.recetarioapp.ui.view.DetailRecipeActivity.Companion.EXTRA_ID
import com.elizabeth.recetarioapp.ui.viewmodel.RecipeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecipeAdapter


    private val recipeViewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recipeViewModel.onCreate()

        adapter = RecipeAdapter(){navigateToDetail(it)}
        binding.rvRecipe.setHasFixedSize(true)
        binding.rvRecipe.layoutManager = LinearLayoutManager(this)
        binding.rvRecipe.adapter = adapter

        initUI()

        recipeViewModel.recipeModel.observe(this, Observer { recipes ->

            adapter.updateListRecipe(recipes)
            Log.i("mensaje","llego aqui")
        })

        recipeViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })


    }

    private fun initUI() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String? ): Boolean {

                CoroutineScope(Dispatchers.IO).launch {
                    recipeViewModel.searchRecipeByName(query.orEmpty())

                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //searchByName(newText.orEmpty())
                return false
            }
        })
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailRecipeActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }

}
