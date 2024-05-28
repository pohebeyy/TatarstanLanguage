package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FraziolagizmActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FraziolagizmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fraziolagizm)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val fraziolagizms = ArrayList<Fraziolagizm>()
        populateFraziolagizms(fraziolagizms)

        adapter = FraziolagizmAdapter(this, fraziolagizms)
        recyclerView.adapter = adapter
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

        }


    }


    private fun populateFraziolagizms(fraziolagizms: ArrayList<Fraziolagizm>) {
        fraziolagizms.add(Fraziolagizm("Язык – зеркало души.", "Тел-күңелнең көзгесе."))
        fraziolagizms.add(Fraziolagizm("Сколько языков – столько стран.", "телләр белгән — илләр  белгән."))
        fraziolagizms.add(Fraziolagizm("Язык может быть и приятным и неприятным.", "тәмле дә тел, тәмсез дә тел."))
        fraziolagizms.add(Fraziolagizm("Язык мой  — враг мой.", "Тартар теленнен табар."))
        fraziolagizms.add(Fraziolagizm("Язык как самая сладкая вещь в мире, так и самая горькая.", "Дөньяда иң татлы нәрсә дә — тел, Иң ачы нәрсә дә — тел."))
        fraziolagizms.add(Fraziolagizm("У кого есть родина, у того есть язык.", "Иле барның теле бар."))
        fraziolagizms.add(Fraziolagizm("Язык придержи на уздечке, собаку на привязи!", "Телеңне тезгендә тот, Этеңне чылбырда тот!"))
        fraziolagizms.add(Fraziolagizm("Острый язык – счастье, Длинный язык – беда.", "Үткен тел – бәхет, Озын тел – бәла!"))
        fraziolagizms.add(Fraziolagizm("Народ, который хранит свой язык, всегда будет в почете.", "Туган телне кадерләгән халык кадерле булыр."))
        fraziolagizms.add(Fraziolagizm("У немого ворона глаза выколет.", "«Көш» дип әйтергән теле юкның күзен карга чукыр."))
        fraziolagizms.add(Fraziolagizm("Длинный язык, как змея: выходит изо рта и душит шею.", "Озын тел елан кебек: авыздан чыкса, муенга урала."))
        fraziolagizms.add(Fraziolagizm("Воду палкой измеряют, а человека языком.", "Суны — таяк белән, кешене тел белән үлчиләр."))
        fraziolagizms.add(Fraziolagizm("Язык может помочь, как подружиться, так и поругаться.", "Сөйдергән дә тел, биздергән дә тел."))
        fraziolagizms.add(Fraziolagizm("Воспитанный умеет разговаривать.", "Әдәп башы – тел."))
        fraziolagizms.add(Fraziolagizm("Рот, как дерево, а язык как топор.", "Агач авыз, балта тел."))
        fraziolagizms.add(Fraziolagizm("Ой, язык, острый как шило.", "Ай-һай телең, тел очыңда безең."))
        fraziolagizms.add(Fraziolagizm("По-русски не знаю, по-татарски понимаю.", "Русчаны белмим, татарчаны аңламыйм."))
        fraziolagizms.add(Fraziolagizm("На языке мед да масло, а под языком ай да ой.", "Суны — таяк белән, кешене тел белән үлчиләр."))
    }
}
