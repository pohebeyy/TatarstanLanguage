package com.example.tatarstannews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class AdvancedLessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_lesson)
        val go:Button = findViewById(R.id.button_nachalo)
        go.setOnClickListener {
            val intent = Intent (this, Lvl1AdvancedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}