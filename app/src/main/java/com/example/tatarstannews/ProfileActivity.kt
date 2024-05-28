package com.example.tatarstannews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBhelper
    private lateinit var currentUserLogin: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        dbHelper = DBhelper(this, null)
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

        // Получаем текущего пользователя
        val currentUser = dbHelper.getCurrentUser()
        if (currentUser != null) {
            currentUserLogin = currentUser.login
        }
        val profile: ImageView = findViewById(R.id.profileIcon)
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)

        }

        val buttonBuyFutbolka = findViewById<Button>(R.id.button_futbolka)
        buttonBuyFutbolka.setOnClickListener {
            buyItem("футболки", 300)
        }

        val buttonBuyKrujka = findViewById<Button>(R.id.button_krujka)
        buttonBuyKrujka.setOnClickListener {
            buyItem("кружки", 200)
        }



        if (this::currentUserLogin.isInitialized) {
            updatePointsDisplay()
            updateRaitDisplay()
        }
    }

    private fun updatePointsDisplay() {
        val points = dbHelper.getUserPoints(currentUserLogin)
        val textViewPoints = findViewById<TextView>(R.id.textViewPoints)
        textViewPoints.text = "Баллы: $points"
    }

    private fun updateRaitDisplay() {
        val rait = dbHelper.getUserPoints(currentUserLogin)
        val textViewRait = findViewById<TextView>(R.id.textViewRait)
        textViewRait.text = "Ваш уровень рейтинга: $rait"
    }

    private fun buyItem(itemName: String, cost: Int) {
        val currentPoints = dbHelper.getUserPoints(currentUserLogin)

        if (currentPoints >= cost) {
            dbHelper.addPoints(currentUserLogin, -cost)
            Toast.makeText(this, "Поздравляем с покупкой $itemName!", Toast.LENGTH_SHORT).show()
            updatePointsDisplay() // Обновляем отображение баллов после успешной покупки
        } else {
            Toast.makeText(this, "У вас недостаточно баллов для покупки $itemName", Toast.LENGTH_SHORT).show()
        }
    }

}
