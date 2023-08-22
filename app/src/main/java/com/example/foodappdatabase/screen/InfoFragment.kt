package com.example.foodappdatabase.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodappdatabase.R
import com.example.foodappdatabase.databinding.FragmentInfoBinding
import com.example.foodappdatabase.utils.Data

class InfoFragment : Fragment() {
    private val binding by lazy { FragmentInfoBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.txtName.text = Data.user!!.name
        binding.txtFoodProduct.text = Data.user!!.mahsulot
        binding.txtPreparationOrder.text = Data.user!!.taktib

        return binding.root
    }

}