package com.example.tatarstannews

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentDostAct : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dostact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Здесь вы можете выполнить любые действия при создании фрагмента
        val DostButton: Button = view.findViewById(R.id.button_dost)
        DostButton.setOnClickListener {
            val intent = Intent(activity, DostAct::class.java)
            startActivity(intent)
        }

    }
}
