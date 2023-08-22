package com.example.foodappdatabase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.foodappdatabase.databinding.ItemRvBinding
import com.example.foodappdatabase.model.User
import com.example.foodappdatabase.screen.ListFragment

class AdapterRv(var list:ArrayList<User>, val click: ListFragment):RecyclerView.Adapter<AdapterRv.Vh>() {
    inner class Vh(var item:ItemRvBinding):ViewHolder(item.root){
        fun onBind(user: User){
            item.txtName.text = user.name
            item.root.setOnClickListener {
                click.click(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    interface Click{
        fun click(user: User)
    }
}