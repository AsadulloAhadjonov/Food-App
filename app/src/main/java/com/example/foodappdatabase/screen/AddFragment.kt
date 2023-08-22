package com.example.foodappdatabase.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodappdatabase.R
import com.example.foodappdatabase.databinding.FragmentAddBinding
import com.example.foodappdatabase.db.DataBaseHelper
import com.example.foodappdatabase.model.User

class AddFragment : Fragment() {
   private val binding by lazy { FragmentAddBinding.inflate(layoutInflater) }
    private lateinit var mydbhelper:DataBaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mydbhelper = DataBaseHelper(binding.root.context)
        binding.btnSave.setOnClickListener {
            val user = User(name = binding.edtFoodName.toString(), mahsulot = binding.edtFoodProducts.toString(), taktib = binding.edtPreparationOrder.toString())
            mydbhelper.addFood(user)
            findNavController().popBackStack()
        }

        return binding.root
    }

}