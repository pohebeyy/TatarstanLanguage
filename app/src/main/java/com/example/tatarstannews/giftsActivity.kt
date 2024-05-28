package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class giftsActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBhelper
    private val currentUserLogin = "username" // Вставьте имя текущего пользователя

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gifts)

        dbHelper = DBhelper(this, null)

        val buttonBuyFutbolka = findViewById<Button>(R.id.button_futbolka)
       buttonBuyFutbolka.setOnClickListener {
            val dbHelper = DBhelper(this, null)
            val currentUser = dbHelper.getCurrentUser()
            val requiredPoints = 300 // Баллы, необходимые для покупки футболки

            if (currentUser != null) {
                val userPoints = dbHelper.getUserPoints(currentUser.login)

                if (userPoints >= requiredPoints) {
                    // Пользователь имеет достаточно баллов для покупки
                    dbHelper.addPoints(currentUser.login, -requiredPoints) // Списываем баллы
                    Toast.makeText(this, "Покупка футболки успешно завершена", Toast.LENGTH_SHORT).show()
                    // Здесь также можете добавить логику отображения футболки или других действий после покупки
                } else {
                    // У пользователя недостаточно баллов для покупки
                    Toast.makeText(this, "Недостаточно баллов для покупки", Toast.LENGTH_SHORT).show()
                }
            }
        }


        val buttonBuyKrujka = findViewById<Button>(R.id.button_krujka)
        buttonBuyKrujka.setOnClickListener {
            val dbHelper = DBhelper(this, null)
            val currentUser = dbHelper.getCurrentUser()
            val requiredPoints = 200 // Баллы, необходимые для покупки футболки

            if (currentUser != null) {
                val userPoints = dbHelper.getUserPoints(currentUser.login)

                if (userPoints >= requiredPoints) {
                    // Пользователь имеет достаточно баллов для покупки
                    dbHelper.addPoints(currentUser.login, -requiredPoints) // Списываем баллы
                    Toast.makeText(this, "Покупка футболки успешно завершена", Toast.LENGTH_SHORT).show()
                    // Здесь также можете добавить логику отображения футболки или других действий после покупки
                } else {
                    // У пользователя недостаточно баллов для покупки
                    Toast.makeText(this, "Недостаточно баллов для покупки", Toast.LENGTH_SHORT).show()
                }
            }
        }



    }

    private fun updatePointsDisplay() {
        val points = dbHelper.getUserPoints(currentUserLogin)
        val textViewPoints = findViewById<TextView>(R.id.textViewPoints)
        textViewPoints.text = "Баллы: $points"
    }

    private fun buyItem(itemName: String, cost: Int) {
        val currentPoints = dbHelper.getUserPoints(currentUserLogin)

        if (currentPoints >= cost) {
            val remainingPoints = currentPoints - cost
            dbHelper.addPoints(currentUserLogin, -cost)
            Toast.makeText(this, "Поздравляем с покупкой $itemName!", Toast.LENGTH_SHORT).show()
            updatePointsDisplay() // Обновляем отображение баллов после успешной покупки
        } else {
            Toast.makeText(this, "У вас недостаточно баллов для покупки $itemName", Toast.LENGTH_SHORT).show()
        }
    }
}
