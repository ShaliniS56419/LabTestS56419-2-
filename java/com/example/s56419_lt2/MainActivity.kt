package com.example.s56419_lt2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun GotoSecondActivity(view: View){
        val intent = Intent(this, WithSharedPreference::class.java).apply{

        }
        startActivity(intent)
    }

    private fun dbExists(c: Context, dbName: String):Boolean{
        val dbFile: File = c.getDatabasePath(dbName)
        return dbFile.exists()
    }
    private fun createDB() {
        val db = openOrCreateDatabase("mydata", MODE_PRIVATE, null)
        subToast("Database  created!")
        val sqlText = "CREATE TABLE IF NOT EXISTS user" +
                "username VARCHAR(30) PRIMARY KEY," +
                "password varchar(30) NOT NULL" +
                ");"
        subToast("Table user created")
        db.execSQL(sqlText)
        var nextSQL = "INSERT INTO user(username,password) VALUES ('ahmad','ahmad1234');"
    }
    private fun subToast(msg: String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}
