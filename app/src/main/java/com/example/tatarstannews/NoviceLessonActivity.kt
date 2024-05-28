package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NoviceLessonActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novice_lesson)
        var continueButton: Button = findViewById(R.id.button_nachalo)


        continueButton.setOnClickListener {
            val intent = Intent(this, Level1_Novice::class.java)
            startActivity(intent)
        }


    }
}
