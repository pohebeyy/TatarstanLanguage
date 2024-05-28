package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Level1_Novice : AppCompatActivity() {

    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level1_novice)

        sharedPreferencesManager = SharedPreferencesManager(this)

        val continueButton1: Button = findViewById(R.id.button_nachalo2)

        continueButton1.setOnClickListener {
            sharedPreferencesManager.saveLevelProgress(1) // Сохранить прогресс уровня 1
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
