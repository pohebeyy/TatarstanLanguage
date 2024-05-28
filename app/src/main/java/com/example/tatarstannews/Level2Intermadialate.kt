package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Level2Intermadialate : AppCompatActivity() {

    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level2_intermadialate)

        sharedPreferencesManager = SharedPreferencesManager(this)

        val go3l: Button = findViewById(R.id.button_nachalo31)
        go3l.setOnClickListener {
            sharedPreferencesManager.saveLevelProgress(5) // Сохранить прогресс уровня 5
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
