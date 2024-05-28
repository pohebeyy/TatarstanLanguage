package com.example.tatarstannews

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Level2_Novice : AppCompatActivity() {

    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level2_novice)

        sharedPreferencesManager = SharedPreferencesManager(this)

        val continueButton2: Button = findViewById(R.id.button_nachalo3)

        continueButton2.setOnClickListener {
            sharedPreferencesManager.saveLevelProgress(2) // Сохранить прогресс уровня 2
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
