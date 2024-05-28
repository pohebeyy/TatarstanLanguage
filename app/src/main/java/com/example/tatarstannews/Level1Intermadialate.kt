package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Level1Intermadialate : AppCompatActivity() {

    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1_intermadialate)

        sharedPreferencesManager = SharedPreferencesManager(this)

        val gol2: Button = findViewById(R.id.button_nachalo21)
        gol2.setOnClickListener {
            sharedPreferencesManager.saveLevelProgress(4) // Сохранить прогресс уровня 4
            val intent = Intent(this, UchebnikActivity::class.java)
            startActivity(intent)
        }
        val profile: ImageView = findViewById(R.id.profileIcon)
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
