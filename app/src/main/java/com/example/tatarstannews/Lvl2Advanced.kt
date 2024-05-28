package com.example.tatarstannews
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Lvl2Advanced : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lvl2_advanced)
        val g3: Button = findViewById(R.id.button_nachalo33)
        g3.setOnClickListener {
            val intent = Intent(this, UchebnikActivity::class.java)
            startActivity(intent)
        }
        val profile: ImageView = findViewById(R.id.profileIcon)
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Save progress for level 8
        SharedPreferencesManager(this).saveLevelProgress(8)
    }
}