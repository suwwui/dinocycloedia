package com.example.dino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val SignIn: Button = findViewById(R.id.signin)
        val Register: Button = findViewById(R.id.register)
        val Menu: Button = findViewById(R.id.menu)

        Menu.setOnClickListener {
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }

        SignIn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        Register.setOnClickListener {
            val intent = Intent(this, com.example.dino.Register::class.java)
            startActivity(intent)
        }

    }



}