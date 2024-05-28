package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Level3_Novice : AppCompatActivity() {

    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level3_novice)



        val button = findViewById<Button>(R.id.button_nachalo3)
        button.setOnClickListener {
            checkAnswersAndAwardPoints()
        }
    }

    private fun checkAnswersAndAwardPoints() {
        val radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup1)
        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)

        val radioButton1Id = radioGroup1.checkedRadioButtonId
        val radioButton2Id = radioGroup2.checkedRadioButtonId

        if (radioButton1Id == -1 || radioButton2Id == -1) {
            Toast.makeText(this, "Пожалуйста, выберите ответы", Toast.LENGTH_SHORT).show()
            return
        }

        val radioButton1 = findViewById<RadioButton>(radioButton1Id)
        val radioButton2 = findViewById<RadioButton>(radioButton2Id)

        val isAnswer1Correct = radioButton1.text == "кояш"
        val isAnswer2Correct = radioButton2.text == "әни"

        if (isAnswer1Correct && isAnswer2Correct) {
            val dbHelper = DBhelper(this, null)
            val currentUser = dbHelper.getCurrentUser()

            if (currentUser != null) {
                dbHelper.addPoints(currentUser.login, 50) // Начислить 50 баллов за успешное прохождение уровня
            }
            if (currentUser != null){
                dbHelper.addReit(currentUser.login,2)
            }


            Toast.makeText(this, "Отлично, ты большой молодец!!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, UchebnikActivity::class.java)
            startActivity(intent)
        } else {
            // Если хотя бы один из ответов неправильный, изменить макет и текст
            val textView = findViewById<TextView>(R.id.textView_nachalo2)
            val imageView = findViewById<ImageView>(R.id.imageView_nachalo)
            textView.text = "Не правильно! Постарайся еще!"
            imageView.setImageResource(R.drawable.pers_fon5)
        }
        val profile: ImageView = findViewById(R.id.profileIcon)
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
