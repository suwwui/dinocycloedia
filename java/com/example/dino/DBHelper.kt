package com.example.dino

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import com.example.dino.DBHelper
import android.os.Bundle
import com.example.dino.R
import android.widget.Toast
import android.content.Intent
import com.example.dino.MainActivity
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.widget.ListView
import com.example.dino.Login

class DBHelper(context: Context,factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    override fun onCreate(myDb: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY," +
                USERNAME_COl + " TEXT," +
                PASSWORD_COL + " TEXT" + ")")
        myDb.execSQL(query)
    }
    //val query2:

    override fun onUpgrade(myDb: SQLiteDatabase, p1: Int, p2: Int) {
        myDb.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(myDb)
    }

    //insert user and passwor data
    //1st method
    fun insertData(username: String, password: String) {
        val values = ContentValues()
        values.put(USERNAME_COl, username)
        values.put(PASSWORD_COL, password)

        val myDb = this.writableDatabase
        myDb.insert(TABLE_NAME, null, values)
        myDb.close()

    }

    //get data
    fun getData(): Cursor? {
        val myDb = this.readableDatabase
        return myDb.rawQuery("SELECT * FROM" + TABLE_NAME, null)
    }


    //checking existing user(2nd method)

    companion object {
        // here we have defined variables for our database

        // below is variable for database name
        private val DATABASE_NAME = "User DB"

        // below is the variable for database version
        private val DATABASE_VERSION = 3

        // below is the variable for table name
        val TABLE_NAME = "user_table"

        val ID_COL = "id"

        // below is the variable for name column
        val USERNAME_COl = "username"

        // below is the variable for age column
        val PASSWORD_COL = "password"

    }
}


