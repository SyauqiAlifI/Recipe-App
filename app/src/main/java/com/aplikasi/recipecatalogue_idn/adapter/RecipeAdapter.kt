package com.aplikasi.recipecatalogue_idn.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.recipecatalogue_idn.DetailActivity
import com.aplikasi.recipecatalogue_idn.data.Recipe
import com.aplikasi.recipecatalogue_idn.databinding.RowItemRecipeBinding
import com.bumptech.glide.Glide

class RecipeAdapter(val listRecipe: ArrayList<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RowItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            with(listRecipe[position]) {
                tvNameRecipe.text = name
                tvCategory.text = calories
                tvPrice.text = price
                Glide.with(imgRecipe.context).load(photo).into(imgRecipe)
            }
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.RECIPE_DATA, listRecipe[position])
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listRecipe.size
}