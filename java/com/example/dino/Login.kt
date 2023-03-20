package com.example.dino

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import android.view.View
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {
    val USER_DATA_PREF = "user data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameSignIn: TextInputEditText = findViewById(R.id.username2)
        val passwordSignIn: TextInputEditText = findViewById(R.id.password2)
        val SignIn: Button = findViewById(R.id.signin2)



        val bundle = intent.extras
        if (bundle != null) {
            usernameSignIn.setText("${bundle.getString("username")}")
            passwordSignIn.setText("${bundle.getString("password")}")
        }

        SignIn.setOnClickListener {

            if(usernameSignIn.text.toString().isNotEmpty() && passwordSignIn.text.toString().isNotEmpty()){

                val intent = Intent(this, homepage::class.java)
                startActivity(intent)

                Toast.makeText(
                    this,
                    "Welcome to Dino",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                Toast.makeText(
                    this,
                    "Please make sure the username and password are filled",
                    Toast.LENGTH_LONG
                ).show()

            }


        }

    }
}



