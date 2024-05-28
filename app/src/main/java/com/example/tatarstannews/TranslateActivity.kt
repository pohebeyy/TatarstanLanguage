package com.example.tatarstannews

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tatarstannews.FillTableTask
import org.jsoup.Jsoup
import java.io.IOException
import java.net.URLEncoder
import kotlin.text.Charsets.UTF_8

class TranslateActivity : AppCompatActivity() {

    private lateinit var translator: Translate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)
        val profile: ImageView = findViewById(R.id.profileIcon)
        profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
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

        findViewById<Button>(R.id.buttonGenerate).setOnClickListener {
            val sourceText = findViewById<EditText>(R.id.editTextWord)
            FillTableTask(
                sourceText,
                findViewById(R.id.such1edin),
                findViewById(R.id.such1mno),
                findViewById(R.id.such2edin),
                findViewById(R.id.such2mno),
                findViewById(R.id.such3edin),
                findViewById(R.id.such3mno),
                findViewById(R.id.such4edin),
                findViewById(R.id.such4mno),
                findViewById(R.id.such5edin),
                findViewById(R.id.such5mno),
                findViewById(R.id.such6edin),
                findViewById(R.id.such6mno)
            ).execute()
        }
    }

    private inner class TranslateTask : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg params: String): String {
            val sourceText = params[0]


            try {
                // 1. Перевод с татарского на русский
                val translatedText = translator.tat2rus(sourceText)
                // 2. Получаем склонения слова
                val casesText = translator.getCases(translatedText)
                // 3. Перевод обратно на татарский
                val backToTatar = translator.rus2tat(casesText)
                return backToTatar
            } catch (e: IOException) {
                Log.e("TranslateTask", "Translation error: ${e.message}")
            }
            return ""
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            // Обновляем UI с результатом
            Log.d("TranslationResult", "Translated text: $result")
            // Выводим результат в таблицу
            updateTable(result)
        }
    }

    private fun updateTable(translatedText: String) {
        // Удаляем начальные и конечные пробелы из строки
        val trimmedText = translatedText.trim()
        // Перевод строки с падежами на массив слов
        val words = trimmedText.split(" ")

        // Проверяем, что у нас достаточно слов для заполнения всех TextView в таблице
        if (words.size < 12) {
            Log.e("UpdateTable", "Not enough words to fill all TextViews")
            return
        }

        // Обновляем каждый TextView в таблице соответствующим переведенным словом
        findViewById<TextView>(R.id.such1edin).text = words[0]
        findViewById<TextView>(R.id.such1mno).text = words[1]
        findViewById<TextView>(R.id.such2edin).text = words[2]
        findViewById<TextView>(R.id.such2mno).text = words[3]
        findViewById<TextView>(R.id.such3edin).text = words[4]
        findViewById<TextView>(R.id.such3mno).text = words[5]
        findViewById<TextView>(R.id.such4edin).text = words[6]
        findViewById<TextView>(R.id.such4mno).text = words[7]
        findViewById<TextView>(R.id.such5edin).text = words[8]
        findViewById<TextView>(R.id.such5mno).text = words[9]
        findViewById<TextView>(R.id.such6edin).text = words[10]

        // Проверяем, достаточно ли слов для последнего TextView
        if (words.size >= 12) {
            findViewById<TextView>(R.id.such6mno).text = words[11]
        }
    }
}



class Translate {
    private val tat2rusUrl = "https://translate.tatar/translate?lang=1&text="
    private val rus2tatUrl = "https://translate.tatar/translate?lang=0&text="
    private val casesUrl = "https://aznaetelivy.ru/sklonenie/"

    @Throws(IOException::class)
    fun getCases(text:String): String {
        val encodedText = URLEncoder.encode(text, UTF_8.toString())
        val url = casesUrl+encodedText
        val doc = Jsoup.connect(url).get()
        val casesElement = doc.select("table")
        return casesElement?.text() ?: "aaaa"
    }

    @Throws(IOException::class)
    fun tat2rus(text: String): String {
        val encodedText = URLEncoder.encode(text, UTF_8.toString())
        val url = tat2rusUrl + encodedText
        val doc = Jsoup.connect(url).get()
        val translationElement = doc.selectFirst("mt")
        return translationElement?.text() ?: "Translation not found"
    }

    @Throws(IOException::class)
    fun rus2tat(text: String): String {
        val encodedText = URLEncoder.encode(text, UTF_8.toString())
        val url = rus2tatUrl + encodedText
        val doc = Jsoup.connect(url).get()
        val translationElement = doc.selectFirst("mt")
        return translationElement?.text() ?: "Translation not found"
    }
}
