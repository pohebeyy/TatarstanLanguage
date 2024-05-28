package com.example.tatarstannews

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "LevelProgress"
    }

    fun saveLevelProgress(level: Int) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("level_$level", true)
        editor.apply()
    }

    fun isLevelCompleted(level: Int): Boolean {
        return sharedPreferences.getBoolean("level_$level", false)
    }

    fun areFirstThreeLevelsCompleted(): Boolean {
        return isLevelCompleted(1) && isLevelCompleted(2) && isLevelCompleted(3)
    }

    fun canAccessLevel(level: Int): Boolean {
        // Проверяем, что предыдущий уровень пройден, чтобы разблокировать следующий
        return if (level == 7) {
            isLevelCompleted(6)
        } else if (level == 8) {
            isLevelCompleted(7)
        } else if (level == 9) {
            isLevelCompleted(8)
        } else {
            // Для всех остальных уровней
            true
        }
    }
}
