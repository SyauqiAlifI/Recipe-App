package com.aplikasi.recipecatalogue_idn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aplikasi.recipecatalogue_idn.data.Recipe
import com.aplikasi.recipecatalogue_idn.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    companion object {
        const val RECIPE_DATA = "recipe"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataRecipe =  intent.getParcelableExtra<Recipe>(RECIPE_DATA) as Recipe

        binding.apply {
            tvCalories.text = dataRecipe.calories
            tvCarbo.text = dataRecipe.carbo
            tvNameRecipeDetail.text = dataRecipe.name
            tvProtein.text = dataRecipe.protein
            tvDescriptionDetail.text = dataRecipe.description
            tvIngredientsDetail.text = dataRecipe.ingredients
            tvInstructionDetail.text = dataRecipe.instruction
        }
        Glide.with(this).load(dataRecipe.photo).into(binding.imgDetail)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}