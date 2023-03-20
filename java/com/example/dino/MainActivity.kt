package com.example.dino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: CardView = findViewById(R.id.aboutdino)
        val button2: CardView = findViewById(R.id.gallerydino)
        val button3: CardView = findViewById(R.id.profiledino)
        val button4: CardView = findViewById(R.id.contactdino)

        button1.setOnClickListener {
            val intent = Intent(this, About::class.java)
            startActivity(intent)

        }
        button2.setOnClickListener {
            val intent = Intent(this,Gallery::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this, Contact::class.java)
            startActivity(intent)
        }
    }
}