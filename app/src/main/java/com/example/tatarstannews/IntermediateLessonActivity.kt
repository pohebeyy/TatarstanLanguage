package com.example.tatarstannews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button



class IntermediateLessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intermediate_lesson)
        val g:Button = findViewById(R.id.button_nachalo)
        g.setOnClickListener {
            val intent = Intent(this, Level1Intermadialate::class.java)
            startActivity(intent)
            finish()
        }
    }

}