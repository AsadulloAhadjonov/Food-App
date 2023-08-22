package com.example.foodappdatabase.db

import com.example.foodappdatabase.model.User

interface DataBase {
    fun addFood(user: User)
    fun getAllFood():List<User>
}