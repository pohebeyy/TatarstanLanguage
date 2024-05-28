package com.example.tatarstannews

import android.os.AsyncTask
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import org.jsoup.Jsoup
import java.io.IOException
import java.net.URLEncoder

class FillTableTask(
    private val editTextWord: EditText,
    private val such1edin: TextView,
    private val such1mno: TextView,
    private val such2edin: TextView,
    private val such2mno: TextView,
    private val such3edin: TextView,
    private val such3mno: TextView,
    private val such4edin: TextView,
    private val such4mno: TextView,
    private val such5edin: TextView,
    private val such5mno: TextView,
    private val such6edin: TextView,
    private val such6mno: TextView
) : AsyncTask<Void, Void, List<String>>() {

    override fun doInBackground(vararg params: Void): List<String> {
        val result = mutableListOf<String>()
        try {
            val tatarWord = editTextWord.text.toString()
            Log.d("FillTableTask", "Tatar word: $tatarWord")

            val russianTranslation = translateToRussian(tatarWord)
            Log.d("FillTableTask", "Russian translation: $russianTranslation")

            if (russianTranslation.isNotEmpty()) {
                val cases = getCasesFromSklonili(russianTranslation)
                Log.d("FillTableTask", "Cases: $cases")

                if (cases.isNotEmpty()) {
                    val tatarCases = cases.map {
                        val tatarCase = translateToTatar(it)
                        Log.d("FillTableTask", "Translating $it to Tatar: $tatarCase")
                        tatarCase
                    }
                    result.addAll(tatarCases)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("FillTableTask", "Error: ${e.message}")
        }
        return result
    }

    override fun onPostExecute(result: List<String>) {

        // Предполагая, что result содержит 12 элементов (6 в единственном числе и 6 во множественном)
        such1edin.text = result.getOrNull(0) ?: ""
        such1mno.text = result.getOrNull(1) ?: ""
        such2edin.text = result.getOrNull(2) ?: ""
        such2mno.text = result.getOrNull(3) ?: ""
        such3edin.text = result.getOrNull(4) ?: ""
        such3mno.text = result.getOrNull(5) ?: ""
        such4edin.text = result.getOrNull(6) ?: ""
        such4mno.text = result.getOrNull(7) ?: ""
        such5edin.text = result.getOrNull(8) ?: ""
        such5mno.text = result.getOrNull(9) ?: ""
        such6edin.text = result.getOrNull(10) ?: ""
        such6mno.text = result.getOrNull(11) ?: ""

    }

    private fun translateToRussian(word: String): String {
        val encodedText = URLEncoder.encode(word, "UTF-8")
        val url = "https://translate.tatar/translate?lang=1&text=$encodedText"
        Log.d("FillTableTask", "URL for Russian translation: $url")
        val doc = Jsoup.connect(url).get()
        val translationElement = doc.selectFirst("mt")
        val translation = translationElement?.text() ?: ""
        Log.d("FillTableTask", "Translation element: $translationElement, text: $translation")
        return translation
    }

    private fun translateToTatar(word: String): String {
        val encodedText = URLEncoder.encode(word, "UTF-8")
        val url = "https://translate.tatar/translate?lang=0&text=$encodedText"
        Log.d("FillTableTask", "URL for Tatar translation: $url")

        try {
            val doc = Jsoup.connect(url).get()
            val body = doc.body()
            if (body != null && body.html().startsWith("<html>") && !body.html().contains("This XML file does not appear to have any style information associated with it.")) {
                // Если тело документа содержит HTML и не содержит текст "This XML file does not appear to have any style information associated with it.",
                // это означает, что перевод имеет HTML-разметку и содержит правильный ответ
                val translationElement = doc.selectFirst("mt")
                var translation = translationElement?.text() ?: ""
                Log.d("FillTableTask", "Translation element: $translationElement, text: $translation")

                // Проверяем, осталась ли переменная translation пустой
                if (translation.isBlank()) {
                    Log.d("FillTableTask", "Translation is empty, using original word: $word")
                    translation = word
                }
                return translation
            } else {
                // Если условие выше не выполнено, возвращаем слово
                Log.d("FillTableTask", "HTML response is empty or does not contain expected content")
                return body?.text() ?: "не удалось перевести"
            }
        } catch (e: Exception) {
            Log.e("FillTableTask", "Error during translation: ${e.message}")
            return "не удалось перевести"
        }
    }







    private fun getCasesFromSklonili(word: String): List<String> {
        val encodedText = URLEncoder.encode(word, "UTF-8")
        val url = "https://sklonili.ru/$encodedText"
        Log.d("FillTableTask", "URL for cases: $url")
        val doc = Jsoup.connect(url).get()
        val tableElements = doc.select("table tbody tr td")

        // Извлекаем только слова, пропуская метки падежей
        val cases = tableElements.mapIndexed { index, element ->
            if (index % 3 == 2) element.text() else null
        }.filterNotNull()

        Log.d("FillTableTask", "Extracted cases: $cases")
        return cases

    }
}