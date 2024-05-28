package com.example.tatarstannews
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class FragmentPiisatAct : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vidoact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Здесь вы можете выполнить любые действия при создании фрагмента
        val VideoButton: Button = view.findViewById(R.id.button_video)
        VideoButton.setOnClickListener {
            val intent = Intent(activity, PisatAct::class.java)
            startActivity(intent)
        }

    }
}
