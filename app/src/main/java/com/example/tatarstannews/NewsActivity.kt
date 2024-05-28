package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class NewsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = NewsAdapter()
        recyclerView.adapter = adapter


        GlobalScope.launch(Dispatchers.IO) {
            val news = parseNews()
            launch(Dispatchers.Main) {
                adapter.setNews(news)
            }
        }
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

    }

    private fun parseNews(): List<NewsItem> {
        val newsList = mutableListOf<NewsItem>()
        try {
            val doc: Document = Jsoup.connect("https://tatar-inform.tatar").get()
            val newsElements: Elements = doc.select(".feed-item__title-text")
            for (element in newsElements) {
                val title = element.text()
                val link = element.parent()?.attr("href")
                link?.let { NewsItem(title, it) }?.let { newsList.add(it) }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return newsList
    }
}