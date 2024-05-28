package com.example.tatarstannews
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.tatarstannews.NewsActivity

import com.example.tatarstannews.R


class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Привязка макета фрагмента
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Находим кнопку в макете фрагмента и назначаем слушатель кликов
        val newsButton: Button = view.findViewById(R.id.button_news)
        newsButton.setOnClickListener {
            val intent = Intent(activity, NewsActivity::class.java)
            startActivity(intent)
        }
    }
}
