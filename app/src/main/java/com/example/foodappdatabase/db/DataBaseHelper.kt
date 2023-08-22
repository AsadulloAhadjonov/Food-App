package com.example.foodappdatabase.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.foodappdatabase.model.User

class DataBaseHelper(context: Context):SQLiteOpenHelper(context, DB_NAME, null ,DB_VERSION), DataBase {
    companion object{
        val DB_NAME = "food_db"
        val DB_VERSION = 1

        val TABLE_NAME="foof_table"
        val FOOD_ID="id"
        val FOOD_NAME="name"
        val FOOD_PRODUCT="product"
        val FOOD_INSTRUCTION="instruction"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table $TABLE_NAME($FOOD_ID integer not null primary key autoincrement unique, $FOOD_NAME text not null, $FOOD_PRODUCT text not null, $FOOD_INSTRUCTION text not null)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    override fun addFood(user: User) {
        val dataBase = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(FOOD_NAME, user.name)
        contentValues.put(FOOD_PRODUCT, user.mahsulot)
        contentValues.put(FOOD_INSTRUCTION, user.taktib)
        dataBase.insert(TABLE_NAME, null, contentValues)
        dataBase.close()
    }

    override fun getAllFood(): List<User> {
        var dataBase = writableDatabase
        var list = ArrayList<User>()
        var query = "select * from $TABLE_NAME"
        var cursor = dataBase.rawQuery(query,null)

        if (cursor.moveToFirst()){
            do {
                var user = User(id = cursor.getInt(0), name = cursor.getString(1), mahsulot = cursor.getString(2), taktib = cursor.getString(3))
                list.add(user)
            }while (cursor.moveToNext())
        }

        return list
    }
}