package com.example.tatarstannews


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class FrazFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Привязка макета фрагмента
        return inflater.inflate(R.layout.fragment_fraz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Находим кнопку в макете фрагмента и назначаем слушатель кликов
        val frazButton: Button = view.findViewById(R.id.button_fraz)
        frazButton.setOnClickListener {
            val intent = Intent(activity, OnlineChat::class.java)
            startActivity(intent)
        }
    }
}
