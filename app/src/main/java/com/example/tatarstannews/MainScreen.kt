package com.example.tatarstannews
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager


class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)


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
        val news: Button = findViewById(R.id.button1)
        news.setOnClickListener {
            val intent = Intent(this,NewsActivity::class.java)
            startActivity(intent)
        }
        val uch:Button = findViewById(R.id.button2)
        uch.setOnClickListener {
            val intent = Intent(this,UchebnikActivity::class.java)
            startActivity(intent)
        }
        val chat:Button = findViewById(R.id.button3)
        chat.setOnClickListener {
            val intent = Intent(this,OnlineChat::class.java)
            startActivity(intent)
        }
        val video:Button = findViewById(R.id.button4)
        video.setOnClickListener {
            val intent = Intent(this, VideoChat::class.java)
            startActivity(intent)

        }

    }
}