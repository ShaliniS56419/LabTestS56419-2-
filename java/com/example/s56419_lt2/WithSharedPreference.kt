package com.example.s56419_lt2

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class WithSharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_shared_preference)
        val btnSave =  findViewById<Button>(R.id.btnSecondAct)
        btnSave.setOnClickListener(){
            val save = findViewById<EditText>(R.id.evUser)
            val sp = this.getSharedPreferences("ahmad", MODE_PRIVATE)

            val iname = findViewById<EditText>(R.id.evUser)
            val ipass = findViewById<EditText>(R.id.evPass)

            iname.setText(sp.getString("username", null))
            ipass.setText(sp.getString("password", null))


            val intent = Intent(this, MainActivity::class.java).apply {

            }
            startActivity(intent)
        }



}

    override fun onPause() {
        super.onPause()
        val iname = findViewById<EditText>(R.id.evUser)
        val ipass = findViewById<EditText>(R.id.evPass)

        val sp = this.getSharedPreferences("ahmad", MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("name", iname.text.toString())
        editor.putString("age", ipass.text.toString())
        editor.commit()
    }
}