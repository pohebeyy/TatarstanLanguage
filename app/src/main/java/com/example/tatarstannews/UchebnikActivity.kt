package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UchebnikActivity : AppCompatActivity() {

    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uchebnik)
        val home: Button = findViewById(R.id.button_glavn)
        home.setOnClickListener {
            val intent = Intent(this,MainScreen::class.java)
            startActivity(intent)
            finish()
        }
        val lk: Button = findViewById(R.id.button_lich)
        lk.setOnClickListener {
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
        val profile: ImageView = findViewById(R.id.profileIcon)
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

        sharedPreferencesManager = SharedPreferencesManager(this)

        // Находим кнопки и добавляем обработчики кликов
        val lesson1Button: Button = findViewById(R.id.lesson1Button)
        val lesson2Button: Button = findViewById(R.id.lesson2Button)
        val lesson3Button: Button = findViewById(R.id.lesson3Button)
        val lesson4Button: Button = findViewById(R.id.lesson4Button)
        val lesson5Button: Button = findViewById(R.id.lesson5Button)
        val lesson6Button: Button = findViewById(R.id.lesson6Button)
        val testButton: Button = findViewById(R.id.lesson7Button)
        val lesson8Button: Button = findViewById(R.id.lesson8Button)
        val lesson9Button: Button = findViewById(R.id.lesson9Button)
        val translateButton: Button = findViewById(R.id.button_translate)

        lesson1Button.setOnClickListener {
            val intent = Intent(this,Level1_Novice::class.java)
            startActivity(intent)
        }

        lesson2Button.setOnClickListener {
            val intent = Intent(this,Level2_Novice::class.java)
            startActivity(intent)
        }

        lesson3Button.setOnClickListener {
            val intent = Intent(this,Level3_Novice::class.java)
            startActivity(intent)

        }

        lesson4Button.setOnClickListener {
            val intent = Intent(this,Level1Intermadialate::class.java)
            startActivity(intent)


        }

        lesson5Button.setOnClickListener {
            val intent = Intent(this,Level2Intermadialate::class.java)
            startActivity(intent)

        }

        lesson6Button.setOnClickListener {
            val intent = Intent(this,Level3Intermadialate::class.java)
            startActivity(intent)


        }

        testButton.setOnClickListener {
            val intent = Intent(this,Lvl1AdvancedActivity::class.java)
            startActivity(intent)

        }

        lesson8Button.setOnClickListener {
            val intent = Intent(this,Lvl2Advanced::class.java)
            startActivity(intent)
        }

        lesson9Button.setOnClickListener {
            val intent = Intent(this,Lvl3Advanced::class.java)
            startActivity(intent)
        }

        translateButton.setOnClickListener {
            startActivity(Intent(this, MoreActivity::class.java))
        }
    }


}
