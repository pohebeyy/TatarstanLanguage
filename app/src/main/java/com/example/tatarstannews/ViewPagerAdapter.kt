package com.example.tatarstannews


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragmentCount = 3
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> NewsFragment()
            1 -> FrazFragment()
            2 -> UchFragment()


            else -> NewsFragment() // Возвращаем NewsFragment по умолчанию
        }
    }

    override fun getCount(): Int {
        return 3
    }
}