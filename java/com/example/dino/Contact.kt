package com.example.dino

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Contact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

                val Link : TextView = findViewById (R.id.link)
                val Menu : Button = findViewById(R.id.menu)
                val Email : TextView = findViewById(R.id.email)


                Link.setOnClickListener {
                    val openURL = Intent(Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://www.nhm.ac.uk/discover/dino-directory.html")
                    startActivity(openURL)
                }

               Menu.setOnClickListener{
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }

              Email.setOnClickListener {
                  val intent = Intent(Intent.ACTION_SEND);
                  intent.type = "plain/text"
                  intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("dino@gmail.com"))
                  startActivity(Intent.createChooser(intent, ""))
                  startActivity(intent)
        }
            }
        }

