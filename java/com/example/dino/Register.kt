package com.example.dino

import  androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val usernameRegister: TextInputEditText = findViewById(R.id.username)
        val passwordRegister: TextInputEditText = findViewById(R.id.password)
        val repasswordRegister: TextInputEditText = findViewById(R.id.repassword)
        val register: Button = findViewById(R.id.register)
        val signIn: Button = findViewById(R.id.signin)


        signIn.setOnClickListener {
            val intent1 = Intent(this, Login::class.java)
            startActivity(intent1)
        }


        register.setOnClickListener {
            val user = usernameRegister.text.toString()
            val pass = passwordRegister.text.toString()
            val repass = repasswordRegister.text.toString()

            val myDb = DBHelper(this, null)

//check for empty space

            if (pass == repass && user.isNotEmpty() && pass.isNotEmpty() && repass.isNotEmpty()) {
                myDb.insertData(user, pass)

                val bundle = Bundle()
                bundle.putString("username", user)
                bundle.putString("password", pass)

                val intent = Intent(this, Login::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
                Toast.makeText(
                    getApplicationContext(),
                    "Successful Registration",
                    Toast.LENGTH_SHORT
                )
                    .show();
            } else {
                Toast.makeText(getApplicationContext(), "Fill all the fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}





