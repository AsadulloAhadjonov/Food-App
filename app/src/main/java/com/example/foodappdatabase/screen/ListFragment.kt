package com.example.foodappdatabase.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.foodappdatabase.R
import com.example.foodappdatabase.adapter.AdapterRv
import com.example.foodappdatabase.databinding.FragmentListBinding
import com.example.foodappdatabase.db.DataBaseHelper
import com.example.foodappdatabase.model.User
import com.example.foodappdatabase.utils.Data

class ListFragment : Fragment(), AdapterRv.Click {
    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private lateinit var adapter: AdapterRv
    private lateinit var myDbHalper: DataBaseHelper
    private lateinit var list: ArrayList<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        list = ArrayList()
        myDbHalper = DataBaseHelper(binding.root.context)
        list.addAll(myDbHalper.getAllFood())
        adapter = AdapterRv(list, this)
        binding.rv.adapter = adapter

        return binding.root
    }

    override fun click(user: User) {
        Data.user = user
        findNavController().navigate(R.id.infoFragment)
    }

}