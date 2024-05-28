package com.example.tatarstannews



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class VideoChat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_chat)


        val confirmButton:Button = findViewById(R.id.confirmButton)
        // Устанавливаем слушатель на кнопку подтверждения
        confirmButton.setOnClickListener {
            // Получаем выбранные значения


            val levelRadioGroup:RadioGroup = findViewById(R.id.levelRadioGroup)
            val ratingRadioGroup:RadioGroup = findViewById(R.id.ratingRadioGroup)


            val selectedLevelId = levelRadioGroup.checkedRadioButtonId
            val selectedRatingId = ratingRadioGroup.checkedRadioButtonId

            // Проверяем, что уровень знаний выбран как "Средний" и рейтинг в диапазоне от 200 до 500
            if (selectedLevelId == R.id.intermediateRadioButton || selectedLevelId == R.id.noviceRadioButton || selectedLevelId == R.id.advancedRadioButton ||
                selectedRatingId == R.id.between200And500RadioButton) {
                // Создаем интент для перехода на активность профиля пользователя
                val intent = Intent(this, UserProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
