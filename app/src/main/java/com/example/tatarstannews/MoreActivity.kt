package com.example.tatarstannews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)
        val translate:Button = findViewById(R.id.button2)

        translate.setOnClickListener {
            val intent = Intent (this,TranslateActivity::class.java)
            startActivity(intent)
        }
        val fraz:Button = findViewById(R.id.button_fraz)
        fraz.setOnClickListener {
            val intent = Intent (this,FraziolagizmActivity::class.java)
            startActivity(intent)
        }
        val profile: ImageView = findViewById(R.id.profileIcon)
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)

        }
        val dos:Button = findViewById(R.id.button_dost)
        dos.setOnClickListener {
            val intent = Intent (this,DostAct::class.java)
            startActivity(intent)
        }
        val avtor:Button = findViewById(R.id.button_avtor)
        avtor.setOnClickListener {
            val intent = Intent (this,PisatAct::class.java)
            startActivity(intent)
        }
    }
}