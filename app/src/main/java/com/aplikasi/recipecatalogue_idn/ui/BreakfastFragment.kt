package com.aplikasi.recipecatalogue_idn.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.recipecatalogue_idn.R
import com.aplikasi.recipecatalogue_idn.adapter.RecipeAdapter
import com.aplikasi.recipecatalogue_idn.data.DataRecipes
import com.aplikasi.recipecatalogue_idn.databinding.FragmentBreakfastBinding

class BreakfastFragment : Fragment() {

    private var _binding: FragmentBreakfastBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBreakfastBinding.inflate(inflater, container, false)

        binding.rvBreakfast.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = RecipeAdapter(DataRecipes.listBreakfast)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}